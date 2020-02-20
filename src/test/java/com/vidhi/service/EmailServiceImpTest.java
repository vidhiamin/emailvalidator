package com.vidhi.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class EmailServiceImpTest {

    @Autowired
    EmailService emailService;

    @TestConfiguration
    static class EmailServiceImpTestConfiguataion{

        @Bean
        public  EmailService getService(){
            return new EmailServiceImp();
        }
    }

    @Test
    public void genericValidation_one_true(){
        int actualResult = 1;
        String email= "firstname@gmail.com, first.name@gmail.com, first+name@gmail.com";
        int result = emailService.findUniqueEmailAddress(email);
        Assert.assertEquals("Not match with the expected result", result,actualResult);
    }
    @Test
    public void genericValidation_zero_true(){
        int actualResult = 0;
        String email= "email..@gmail.com, @gmail.com, email format@gmail.com, 12345678@google.com";
        int result = emailService.findUniqueEmailAddress(email);
        Assert.assertEquals("Not match with the expected result", result, actualResult);
    }
    @Test
    public void genericValidation_two_true() {
        int actualResult = 2;
        String email= "email11@gmail.com, firstname.lastname@gmail.com, .email@gmail.com, email.@gmail.com, email+format@gmail.com";
        int result = emailService.findUniqueEmailAddress(email);
        Assert.assertEquals("Not match with the expected result", result, actualResult);

    }
}