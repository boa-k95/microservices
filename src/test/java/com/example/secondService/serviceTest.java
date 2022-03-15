package com.example.secondService;

import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.services.generatedNumberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(SpringJUnit4ClassRunner.class)

public class serviceTest extends BaseclassTest {

    @MockBean
    private generatedNumberService service;

    @Test
    public void testRandomNumberOk() {
        CommandInput input = new CommandInput();
        input.setNumber(9);
        int number = input.getNumber();

        int mockedResponse = 18;

        Mockito.when(service.checkSize(number)).thenReturn(mockedResponse);
        Assert.assertEquals(mockedResponse, 18);
    }

    @Test
    public void testRandomNumberKO() {
        CommandInput input = new CommandInput();
        input.setNumber(9);
        int number = input.getNumber();

        int mockedResponse = 18;

        Mockito.when(service.checkSize(anyInt())).thenReturn(18);
        int expected = service.checkSize(number);
        Assert.assertEquals("same number", expected, mockedResponse);

    }


}


