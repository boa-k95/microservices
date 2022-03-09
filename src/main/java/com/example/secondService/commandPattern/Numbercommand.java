package com.example.secondService.commandPattern;

import com.example.secondService.services.generatedNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class Numbercommand extends BaseCommand<CommandOutput> {
   private final CommandInput input;
@Autowired private generatedNumberService service;

@Override
    public CommandOutput execute() throws Exception {
        CommandOutput output = new CommandOutput();

       int number = service.checkSize(input.getNumber());

       output.setRandomNumber(number);
        return output;

    }
}
