package com.example.secondService.factory;


import com.example.secondService.DTO.requestDTO;
import com.example.secondService.commandPattern.checkcommandInput;
import com.example.secondService.model.request;
import org.springframework.stereotype.Component;

@Component
public class requestFactory {

    public checkcommandInput createcheckcommandInput(request req){

        requestDTO reqDTO = createrequest(req);

       checkcommandInput input = new checkcommandInput();
       input.setDto(reqDTO);
       return  input;
    }

    private static requestDTO createrequest (request req){
        requestDTO reqDTO = new requestDTO();
        if(req != null){
             reqDTO.setType(req.getType().name());
             reqDTO.setEmail(req.getCustomer().getEmail());
 }
        return reqDTO;
    }



}
