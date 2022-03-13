package com.example.secondService.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class generatedNumberService {
    private static final Logger logger = LoggerFactory.getLogger(generatedNumberService.class);

    public int checkSize(int number) {

        return number * 2;
    }

}