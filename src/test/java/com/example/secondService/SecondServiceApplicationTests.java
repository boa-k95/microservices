package com.example.secondService;
import com.example.secondService.commandPattern.CommandInput;
import com.example.secondService.commandPattern.CommandOutput;
import com.example.secondService.commandPattern.Numbercommand;
import com.example.secondService.factory.GeneralDTOfactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SecondServiceApplicationTests extends BaseTestClass {

	 @Autowired private BeanFactory beanFactory;
	 @Autowired private GeneralDTOfactory DTOfactory;


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
