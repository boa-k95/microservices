package com.example.secondService.DTO;

import com.example.secondService.model.AccType;

import com.example.secondService.model.Customer;
import lombok.Data;

@Data
public class RequestDTO {

    private String number;
    private AccType type;
    private Customer cus;
    }
