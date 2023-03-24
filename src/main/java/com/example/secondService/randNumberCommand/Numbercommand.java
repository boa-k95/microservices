package com.example.secondService.randNumberCommand;

import com.example.secondService.services.GeneratedNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class Numbercommand extends BaseCommand<CommandOutput> {
   private final CommandInput input;
@Autowired private GeneratedNumberService service;

@Override
    public CommandOutput execute() throws Exception {
        CommandOutput output = new CommandOutput();

       int number = service.checkSize(input.getNumber());

     logger.info("final list numbers --------> {}",getRandomNumbers());

    output.setRandomNumber(number);
        return output;

    }

    public static List<?extends Object> getRandomNumbers(){
    var number =  Arrays.asList("ciao","kurtis","boama");
    var upperCase =   number.stream().map(String::toUpperCase).collect(Collectors.toList());
    return  upperCase;

}
}
