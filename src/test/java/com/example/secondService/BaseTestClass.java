package com.example.secondService;

import com.example.ConfigClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Configuration
@ContextConfiguration(classes = {ConfigClass.class})
@ActiveProfiles("app-svil")
@RunWith(SpringRunner.class)
public abstract class BaseTestClass {


}
