package com.example.command.randomNumberTest;

import com.example.secondService.BaseClassTest;
import com.example.secondService.randNumberCommand.CommandInput;
import com.example.secondService.randNumberCommand.CommandOutput;
import com.example.secondService.randNumberCommand.Numbercommand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class RandomnumberCommandTest extends BaseClassTest {
    @Autowired private BeanFactory beanFactory;

    @Test
    public void getCommandResult() throws Exception {
        int userInput = 18;
        CommandOutput acceptedOutput = new CommandOutput();
        acceptedOutput.setRandomNumber(userInput);

        //input for the test
        int randomNumber = 9;
        CommandInput commandInput =new CommandInput();
        commandInput.setNumber(randomNumber);

        Numbercommand command = beanFactory.getBean(Numbercommand.class, commandInput);

        CommandOutput output = command.execute();
        Assert.assertEquals(acceptedOutput.getRandomNumber(),output.getRandomNumber());
    }
}
