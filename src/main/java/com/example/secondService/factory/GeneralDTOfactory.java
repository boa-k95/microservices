package com.example.secondService.factory;

import com.example.secondService.command.CommandInput;
import com.example.secondService.model.customer;
import com.example.secondService.command.dto.customerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeneralDTOfactory {
    private static final Logger logger = LoggerFactory.getLogger(GeneralDTOfactory.class);

    public static CommandInput getcreatecustomerDTO(customer customer) {
        CommandInput input = new CommandInput();
        customerDTO DTO = new customerDTO();
        DTO.setID(customer.getID());
        DTO.setName(customer.getName());
        DTO.setSurname(customer.getSurname());

        //input.setCliente(DTO);
        return input;
    }

    public static CommandInput createIntegerNumber(int number) {

        logger.info("{}", number);

        CommandInput input = new CommandInput();
        input.setNumber(number);
        return input;
    }
}
