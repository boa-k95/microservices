package com.example.secondService.factory;

import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.model.request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class checkInfoCommandFactory {
    public static final String WELCOME_TEXT= "Welcome" ;

    @Autowired commonFactory commonfactory;
    private static final Logger logger = LoggerFactory.getLogger(checkInfoCommandFactory.class);

    public static CommandInput createIntegerNumber(int number) {

        logger.info("{}", number);

        CommandInput input = new CommandInput();
        input.setNumber(number);
        return input;
    }


    public static checkcommandInput createcheckCommandInput(request req){
          String message = WELCOME_TEXT.concat(req.getCustomer().getName());
        checkcommandInput input = new checkcommandInput();
        input.setDto(req);
        input.setWelcome_text(message);
        logger.info("inputCommand-------> {}",input);
        return  input;
    }


}
