package com.example.secondService;

import com.example.factory.CommonFactoryTest;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import com.example.secondService.services.GetInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class GetInfoserviceTest extends BaseClassTest {

    @MockBean
    private GetInfoService service;


    private static checkcommandOutput COMMAND_OUTPUT = new checkcommandOutput();


    static {
        COMMAND_OUTPUT.setReturnCustomer(CommonFactoryTest.CUSTOMER);
    }

    @Test
    public void checkspybean() {
        Mockito.when(service.checkSuccess(CommonFactoryTest.COMMAND_INPUT)).thenReturn(COMMAND_OUTPUT);
        String testcustomerName = COMMAND_OUTPUT.getReturnCustomer().getName();
        assertEquals(testcustomerName, COMMAND_OUTPUT.getReturnCustomer().getName());
    }

    @Test
    public void NameNotEqual() {
        Mockito.when(service.checkSuccess(CommonFactoryTest.COMMAND_INPUT)).thenReturn(COMMAND_OUTPUT);
        String testcustomerName = "kurtis";
        assertEquals(testcustomerName, COMMAND_OUTPUT.getReturnCustomer().getName());
    }
}
