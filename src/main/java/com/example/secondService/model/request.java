package com.example.secondService.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

@Data
public class request {

    @Nullable
    private String number;
    @Autowired
    @NotBlank
    private customer customer;
    private accType type;
}
