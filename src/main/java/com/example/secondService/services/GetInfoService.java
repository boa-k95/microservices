package com.example.secondService.services;


import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import com.example.secondService.factory.commonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetInfoService {
    public static final String WELCOME_MESSAGE = "WELCOMEtoSTO";
    @Autowired
    private commonFactory factory;

    public checkcommandOutput checkSuccess(checkcommandInput input) {
        checkcommandOutput output = new checkcommandOutput();

        if (input != null){
            output.setReturnCustomer(input.getDto().getPerson());
        }
        return  output;
    }



}
