package com.example.secondService.controller;


import com.example.secondService.commandPattern.CommandInput;
import com.example.secondService.commandPattern.CommandOutput;
import com.example.secondService.commandPattern.Numbercommand;
import com.example.secondService.factory.GeneralDTOfactory;
import com.example.secondService.model.customer;
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
import java.util.ArrayList;
import java.util.List;

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
    private RestTemplate restTemplate;

    @Value("${token}")
    private String token;

    @Value("${my.app}")
    private String appName;

    static List<String> city = new ArrayList<>();

    static {
        city.add("Rome");
        city.add("Torino");
        city.add("Palermo");
    }


    @GetMapping(value = "/message/{num}")
    public @ResponseBody String showMessage(@PathVariable int num) throws Exception {

          String localAddress = null;

        localAddress = InetAddress.getLocalHost().getHostAddress();
        logger.info("----TOKEN ---- {}", token);
        logger.info("----APP NAME ---- {}",appName );
        logger.info("----LOCAL ADDRESS ---- {}", localAddress);
        CommandInput input = generalDTOfactory.createIntegerNumber(num);
        Numbercommand commandExecute = beanFactory.getBean(Numbercommand.class, input);
        CommandOutput Output = commandExecute.execute();
        logger.info("CommandOutput--------->{}", Output);
        return "token:: ".concat(token)+" "+Output.getRandomNumber();
    }


    @PostMapping()
    public ResponseEntity<String> getInformattion(@RequestBody @Valid customer cus){


    }
}
