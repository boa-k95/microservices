package com.example.factory;

import com.example.secondService.BaseclassTest;
import com.example.secondService.DTO.customerDTO;
import com.example.secondService.DTO.requestDTO;
import com.example.secondService.factory.commonFactory;
import com.example.secondService.model.accType;
import com.example.secondService.model.customer;
import com.example.secondService.model.request;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class commonFactoryTest extends BaseclassTest {
    public static final String WELCOME_TEXT_TEST = "Welcome";

    @Autowired private commonFactory commonfactory;
    public static final customer CUSTOMER = new customer();

    static {
        CUSTOMER.setID(74749);
        CUSTOMER.setName("kurtis");
        CUSTOMER.setEmail("kurtisboama@gmail.com");
        CUSTOMER.setSurname("boama");
    }

 public static final customerDTO CUSTOMER_DTO = new customerDTO();

    static {
        CUSTOMER_DTO.setID(CUSTOMER.getID());
        CUSTOMER_DTO.setEmail(CUSTOMER.getEmail());
        CUSTOMER_DTO.setSurname(CUSTOMER.getSurname());
        CUSTOMER_DTO.setName(CUSTOMER.getName());
    }

    public static final request REQUEST = new request();

     static{
         REQUEST.setNumber("795");
         REQUEST.setCustomer(CUSTOMER);
         REQUEST.setType(accType.MAGG_CHILD);
     }
 public static final requestDTO REQUEST_DTO = new requestDTO();
     static {
         REQUEST_DTO.setNumber(REQUEST.getNumber());
         REQUEST_DTO.setCus(REQUEST.getCustomer());
         REQUEST_DTO.setType(REQUEST.getType());

     }

     @Test
    public void checkBothCustomerObjects(){
        assertEquals("wrong different objects",commonFactoryTest.CUSTOMER ,commonfactory.createCustomerEntity(commonFactoryTest.CUSTOMER_DTO));
     }


     @Test
     public void checkBothRequestObjects(){
         assertEquals("wrong different objects",commonFactoryTest.REQUEST ,commonfactory.createRequest(commonFactoryTest.REQUEST_DTO));

     }
}
