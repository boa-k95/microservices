package com.example.secondService.controller;


import com.example.secondService.checkInfoCommand.checkCommand;
import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import com.example.secondService.factory.checkInfoCommandFactory;
import com.example.secondService.model.Customer;
import com.example.secondService.model.Request;
import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.randNumberCommand.CommandOutput;
import com.example.secondService.randNumberCommand.Numbercommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping(value = "getId")
public class secondController {
    private static final Logger logger = LoggerFactory.getLogger(secondController.class);
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private checkInfoCommandFactory checkInfoCommandfactory;


    @Value("${welcome_message : not found}")
    private String appName;

    @GetMapping(value = "/message/{num}")
    public String showMessage(@PathVariable int num) throws Exception {

        String localAddress = null;


        localAddress = InetAddress.getLocalHost().getHostAddress();
        logger.info("----LOCAL ADDRESS ---- {}", localAddress);
        CommandInput input = checkInfoCommandfactory.createIntegerNumber(num);
        Numbercommand commandExecute = beanFactory.getBean(Numbercommand.class, input);
        CommandOutput Output = commandExecute.execute();
        logger.info("CommandOutput--------->{}", Output);
        return "---------".concat(appName) + "----" + Output.getRandomNumber();
    }


    @GetMapping("/getConfigurations")
    public @ResponseBody
    Map<String, String> getAllConfig() {
        Properties systemProperties = System.getProperties();
        Enumeration enuProp = systemProperties.propertyNames();
        logger.info("GETTING ALL CONFIGURATIONS-----");
        Map<String, String> getAllConfig = new HashMap<>();
        while (enuProp.hasMoreElements()) {
            String propertyName = (String) enuProp.nextElement();
            String propertyValue = systemProperties.getProperty(propertyName);
            getAllConfig.put(propertyName, propertyValue);
        }
        return getAllConfig;
    }

    @GetMapping(value = "/check")
    public Customer getInformation(@RequestBody @Valid Request req) throws Exception {
        logger.info("original Request------>{}",req);
        checkcommandInput input = checkInfoCommandfactory.createcheckCommandInput(req);
         logger.info("checkcommandinput ----->{}",req);

        checkCommand command = beanFactory.getBean(checkCommand.class, input);
        checkcommandOutput output = command.execute();
        return output.getReturnCustomer();
    }
}
