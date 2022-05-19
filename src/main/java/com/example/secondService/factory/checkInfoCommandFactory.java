package com.example.secondService.factory;

import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.model.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class checkInfoCommandFactory {
    public static final String WELCOME_TEXT= "Welcome" ;

    @Autowired private commonFactory commonfactory;
    private static final Logger logger = LoggerFactory.getLogger(checkInfoCommandFactory.class);

    public static CommandInput createIntegerNumber(int number) {

        logger.info("{}", number);

        CommandInput input = new CommandInput();
        input.setNumber(number);
        return input;
    }


    public checkcommandInput createcheckCommandInput(Request req){
        checkcommandInput input = new checkcommandInput();

        if(req!=null) {
            input.setDto(req);
        }
        logger.info("inputCommand-------> {}",input);
        return  input;
    }


}
