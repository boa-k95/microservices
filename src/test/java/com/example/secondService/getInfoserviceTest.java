package com.example.secondService;

import com.example.factory.commonFactoryTest;
import com.example.secondService.checkInfoCommand.checkcommandInput;
import com.example.secondService.checkInfoCommand.checkcommandOutput;
import com.example.secondService.services.getInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class getInfoserviceTest extends  BaseclassTest {

     @MockBean private getInfoService service;
     @Autowired

   @Test
    public void testWelcomeText(){
         checkcommandInput input = new checkcommandInput();
         checkcommandOutput MOCKED_RESPONSE =new checkcommandOutput();
        input.setDto(commonFactoryTest.REQUEST);
         MOCKED_RESPONSE.setMessage(getInfoService.WELCOME_MESSAGE.concat("").concat(commonFactoryTest.REQUEST.getCustomer().getName()));

         Mockito.when(service.checkSuccess(input)).thenReturn(MOCKED_RESPONSE);


    }
}
