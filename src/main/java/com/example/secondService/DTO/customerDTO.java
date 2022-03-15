package com.example.secondService.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class customerDTO {

    private long ID;
    private String name;
    private String surname;
    private String email;
}
