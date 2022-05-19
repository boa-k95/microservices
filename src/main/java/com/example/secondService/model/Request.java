package com.example.secondService.model;

import lombok.Data;

@Data
public class Request {
    private String number;
    private Customer person;
    private AccType type;
}
