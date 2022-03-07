package com.example.secondService.command;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CommandInput {

    private int number;
}
