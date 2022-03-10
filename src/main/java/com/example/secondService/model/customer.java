package com.example.secondService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class customer {
    @NotNull private long ID;
       @NotBlank private String name;
     @NotBlank private String surname;

     @Autowired private request request;
}
