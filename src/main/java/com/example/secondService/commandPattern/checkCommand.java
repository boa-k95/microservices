package com.example.secondService.commandPattern;

import com.example.secondService.services.getInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class checkCommand extends BaseCommand<Boolean> {

    private final checkcommandInput input;
    @Autowired private getInfoService service;

    @Override
    public Boolean execute() throws Exception {
        checkcommandOutput output = new checkcommandOutput();

        Boolean success = service.checkSuccess(input.getDto());
        return success;

    }
}
