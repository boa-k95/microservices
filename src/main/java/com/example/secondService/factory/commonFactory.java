package com.example.secondService.factory;


import com.example.secondService.DTO.customerDTO;
import com.example.secondService.DTO.requestDTO;
import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.model.customer;
import com.example.secondService.model.request;
import org.springframework.stereotype.Component;

@Component
public class commonFactory {

    public customer createCustomerEntity(customerDTO dto){
        customer cus = new customer();
        cus.setName(dto.getName());
        cus.setSurname(dto.getSurname());
        cus.setEmail(dto.getEmail());
        return  cus;
    }

    public request createRequest(requestDTO reqDTO){
        request req = new request();
        req.setPerson(reqDTO.getCus());
        req.setNumber(reqDTO.getNumber());
        req.setType(reqDTO.getType());
        return  req;
    }
    public customerDTO createReturnCustomerDTO(checkcommandInput input){
        customerDTO dto = new customerDTO() ;
        if (input!=null){
            dto.setName(input.getDto().getPerson().getName());
            dto.setEmail(input.getDto().getPerson().getEmail());
            dto.setSurname(input.getDto().getPerson().getSurname());
        }
        return  dto;
    }
}
