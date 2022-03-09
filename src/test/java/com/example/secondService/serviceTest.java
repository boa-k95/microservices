package com.example.secondService;

import com.example.secondService.commandPattern.CommandInput;
import com.example.secondService.services.generatedNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.Returns;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class serviceTest extends BaseTestClass {

    @MockBean private generatedNumberService service;

    @Test
    public void testMaskedTextOk() {
    CommandInput input = new CommandInput();
       input.setNumber(9);
       int number = input.getNumber();

       Mockito.when(service.checkSize(number)).thenReturn(number*2);




    }
}
