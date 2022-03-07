package com.example.secondService.command.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class customerDTO {
    @JsonIgnore private long ID;
    private String surname;
    private String name;
}
