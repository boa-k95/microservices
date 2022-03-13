package com.example.secondService.services;

import com.example.secondService.DTO.requestDTO;
import org.springframework.stereotype.Service;

@Service
public class getInfoService {

    public  boolean checkSuccess(requestDTO dtoRequest) {

        if (dtoRequest != null) {

            return true;
        }

        return false;
    }
}