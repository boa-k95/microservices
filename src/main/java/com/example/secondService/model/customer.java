package com.example.secondService.model;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Component
public class customer {
    @NotNull
    private long ID;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    private String email;

}
