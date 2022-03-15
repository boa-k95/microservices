package com.example.secondService.services;


import com.example.secondService.checkInfoCommand.checkcommandInput;
import org.springframework.stereotype.Service;

@Service
public class getInfoService {

    public String checkSuccess(checkcommandInput input) {
        String messageToPublish;
        if (input != null) {

        messageToPublish = input.getWelcome_text();
        }
        else{
            return  null;
        }
        return messageToPublish;
    }


}
