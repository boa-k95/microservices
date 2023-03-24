package com.example.secondService.main;

import com.example.ConfigClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication(scanBasePackageClasses = {ConfigClass.class})
public class SecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondServiceApplication.class, args);
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("E" +
                ". yyyy-MM-dd");

        System.out.println(FOMATTER.format(LocalDate.now()));
    }


}
