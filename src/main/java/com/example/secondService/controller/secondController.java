package com.example.secondService.controller;


import com.example.secondService.command.CommandInput;
import com.example.secondService.command.CommandOutput;
import com.example.secondService.command.command;
import com.example.secondService.factory.GeneralDTOfactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "consumer")
public class secondController {
    private static final Logger logger = LoggerFactory.getLogger(secondController.class);
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private GeneralDTOfactory generalDTOfactory;

    @Value("${token:irurorroir}")
    private String token;

    static List<String> city = new ArrayList<>();

    static {
        city.add("Rome");
        city.add("Torino");
        city.add("Palermo");
    }


    @GetMapping(value = "/message/{num}", produces = "application/xml")
    public @ResponseBody
    int showMessage(@PathVariable int num) throws Exception {

        logger.info("----TOKEN ---- {}", token);
        CommandInput input = generalDTOfactory.createIntegerNumber(num);
        command commandExecute = beanFactory.getBean(command.class, input);
        CommandOutput Output = commandExecute.execute();
        logger.info("CommandOutput--------->{}", Output);
        return Output.getRandomNumber();
    }
}
