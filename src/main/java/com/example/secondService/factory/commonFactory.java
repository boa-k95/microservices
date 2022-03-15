package com.example.secondService.factory;


import com.example.secondService.DTO.customerDTO;
import com.example.secondService.DTO.requestDTO;
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
        cus.setID(dto.getID());
        return  cus;
    }

    public request createRequest(requestDTO reqDTO){
        request req = new request();
        req.setCustomer(reqDTO.getCus());
        req.setNumber(reqDTO.getNumber());
        reqDTO.setType(reqDTO.getType());
        return  req;
    }
}
