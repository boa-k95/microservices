package com.example.secondService.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class Customer {

    @NotBlank
    @JsonProperty("Customer Name")
    private String name;
    @NotBlank
    @JsonProperty("Customer Surname")
    private String surname;
    @Email
    @JsonProperty("Customer Email")
    private String email;

}
