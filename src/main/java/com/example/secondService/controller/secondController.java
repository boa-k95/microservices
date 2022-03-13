package com.example.secondService.controller;


import com.example.secondService.commandPattern.*;
import com.example.secondService.factory.GeneralDTOfactory;
import com.example.secondService.factory.requestFactory;
import com.example.secondService.model.request;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    private GeneralDTOfactory generalDTOfactory;

    @Autowired
    private requestFactory reqFactory;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${token}")
    private String token;

    @Value("${my.app}")
    private String appName;

    @GetMapping(value = "/message/{num}")
    public @ResponseBody String showMessage(@PathVariable int num) throws Exception {

          String localAddress = null;



        localAddress = InetAddress.getLocalHost().getHostAddress();
        logger.info("----LOCAL ADDRESS ---- {}", localAddress);
        CommandInput input = generalDTOfactory.createIntegerNumber(num);
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
    public ResponseEntity<checkcommandOutput> getInformattion(@RequestBody @Valid request req) throws Exception {

    checkcommandInput input = reqFactory.createcheckcommandInput(req);
    checkCommand command = beanFactory.getBean(checkCommand.class, input);
    Boolean output = command.execute();
    checkcommandOutput commandoutput = new checkcommandOutput();
    commandoutput.setSuccess(output);
    return ResponseEntity.ok(commandoutput);
    }
}
