package com.example.secondService.services;


import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import org.springframework.stereotype.Service;

@Service
public class getInfoService {
    public static final String WELCOME_MESSAGE = "WELCOME";
    public checkcommandOutput checkSuccess(checkcommandInput input) {

      checkcommandOutput output  = new checkcommandOutput();

        if (input != null) {

        output.setMessage(WELCOME_MESSAGE.concat(" ").concat(input.getDto().getCustomer().getName()));
        }
        else{
            return  null;
        }
        return output;
    }


}
