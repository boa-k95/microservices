package com.example.secondService.controller;


import com.example.secondService.checkInfoCommand.checkCommand;
import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import com.example.secondService.randNumberCommand.*;
import com.example.secondService.factory.checkInfoCommandFactory;
import com.example.secondService.factory.commonFactory;
import com.example.secondService.model.request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetAddress;
import java.util.*;

@RestController
@RequestMapping(value = "getId")
@RefreshScope
public class secondController {
    private static final Logger logger = LoggerFactory.getLogger(secondController.class);
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private checkInfoCommandFactory checkInfoCommandfactory;

    @Autowired private commonFactory commonfactory;


    @Value("${token}")
    private String token;

    @Value("${my.app}")
    private String appName;

    @GetMapping(value = "/message/{num}")
    public @ResponseBody String showMessage(@PathVariable int num) throws Exception {

          String localAddress = null;



        localAddress = InetAddress.getLocalHost().getHostAddress();
        logger.info("----LOCAL ADDRESS ---- {}", localAddress);
        CommandInput input = checkInfoCommandfactory.createIntegerNumber(num);
        Numbercommand commandExecute = beanFactory.getBean(Numbercommand.class, input);
        CommandOutput Output = commandExecute.execute();
        logger.info("CommandOutput--------->{}", Output);
        return "---------".concat(token)+"----"+Output.getRandomNumber();
    }


    @GetMapping("/getConfigurations")
    public @ResponseBody Map<String,String> getAllConfig(){
        Properties systemProperties = System.getProperties();
        Enumeration enuProp = systemProperties.propertyNames();
     logger.info("GETTING ALL CONFIGURATIONS-----");
         Map<String,String> getAllConfig = new HashMap<>();
        while (enuProp.hasMoreElements()) {
            String propertyName = (String) enuProp.nextElement();
            String propertyValue = systemProperties.getProperty(propertyName);
            getAllConfig.put(propertyName,propertyValue);
        }
        return getAllConfig;
    }

   @PostMapping(value = "/check")
    public @ResponseBody String  getInformattion(@RequestBody @Valid request req) throws Exception {
    checkcommandInput input = checkInfoCommandfactory.createcheckCommandInput(req);

    checkCommand command = beanFactory.getBean(checkCommand.class, input);
       checkcommandOutput output = command.execute();
    checkcommandOutput commandoutput = new checkcommandOutput();

    return commandoutput.getMessage();
    }
}
