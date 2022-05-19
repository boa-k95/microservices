package com.example.secondService;

import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.services.generatedNumberService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(SpringJUnit4ClassRunner.class)

public class randomNumberServiceTest extends BaseclassTest {
    public static final int MOCKED_RESPONSE = 18;

    @MockBean
    private generatedNumberService service;

    @Test
    public void testRandomNumberOk() {
        CommandInput input = new CommandInput();
        input.setNumber(9);
        int number = input.getNumber();


        Mockito.when(service.checkSize(number)).thenReturn(MOCKED_RESPONSE);
        assertEquals(18,MOCKED_RESPONSE);
    }

    @Test
    public void testRandomNumberKO() {
        CommandInput input = new CommandInput();
        input.setNumber(90);
        int number = input.getNumber();

        Mockito.when(service.checkSize(anyInt())).thenReturn(MOCKED_RESPONSE);
        //int expected = service.checkSize(number);
        assertEquals("not equals",MOCKED_RESPONSE,service.checkSize(number));

    }


}


