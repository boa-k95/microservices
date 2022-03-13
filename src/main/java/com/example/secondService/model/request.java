package com.example.secondService.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class request {

    @NotNull @NotBlank @NotEmpty
    private String number;
    private customer customer;
    private accType type;
}
