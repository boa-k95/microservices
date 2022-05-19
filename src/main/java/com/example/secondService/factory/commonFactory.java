package com.example.secondService.factory;


import com.example.secondService.DTO.customerDTO;
import com.example.secondService.DTO.requestDTO;
import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.model.Customer;
import com.example.secondService.model.Request;
import org.springframework.stereotype.Component;

@Component
public class commonFactory {

    public Customer createCustomerEntity(customerDTO dto){
        Customer cus = new Customer();
        cus.setName(dto.getName());
        cus.setSurname(dto.getSurname());
        cus.setEmail(dto.getEmail());
        return  cus;
    }

    public Request createRequest(requestDTO reqDTO){
        Request req = new Request();
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
