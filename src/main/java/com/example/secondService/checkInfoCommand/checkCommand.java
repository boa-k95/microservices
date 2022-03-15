package com.example.secondService.checkInfoCommand;

import com.example.secondService.randNumberCommand.BaseCommand;
import com.example.secondService.services.getInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class checkCommand extends BaseCommand<checkcommandOutput> {

    private final checkcommandInput input;
    @Autowired private getInfoService service;


    @Override
    public checkcommandOutput execute() throws Exception {
        checkcommandOutput output = new checkcommandOutput();
        String success = service.checkSuccess(input);
         output.setMessage(success);
        return output;

    }
}
