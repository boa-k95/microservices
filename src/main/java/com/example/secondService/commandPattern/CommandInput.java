package com.example.secondService.commandPattern;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommandInput {

    private int number;
}
