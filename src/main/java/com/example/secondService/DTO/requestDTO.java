package com.example.secondService.DTO;

import com.example.secondService.model.accType;

import com.example.secondService.model.customer;
import lombok.Data;

@Data
public class requestDTO {

    private String number;
    private accType type;
    private customer cus;
    }
