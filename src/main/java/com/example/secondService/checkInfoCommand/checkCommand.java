package com.example.secondService.checkInfoCommand;

import com.example.secondService.randNumberCommand.BaseCommand;
import com.example.secondService.services.GetInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class checkCommand extends BaseCommand<checkcommandOutput> {

    private final checkcommandInput input;
    @Autowired
    private GetInfoService service;


    @Override
    public checkcommandOutput execute()  {
        checkcommandOutput output;
        output = service.checkSuccess(input);
        return output;

    }
}
