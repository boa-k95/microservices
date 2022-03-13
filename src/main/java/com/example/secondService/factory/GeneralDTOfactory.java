package com.example.secondService.factory;

import com.example.secondService.commandPattern.CommandInput;
import com.example.secondService.model.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GeneralDTOfactory {
    private static final Logger logger = LoggerFactory.getLogger(GeneralDTOfactory.class);

    public static CommandInput createIntegerNumber(int number) {

        logger.info("{}", number);

        CommandInput input = new CommandInput();
        input.setNumber(number);
        return input;
    }
}
