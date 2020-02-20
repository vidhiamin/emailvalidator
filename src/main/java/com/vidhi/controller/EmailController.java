package com.vidhi.controller;

import com.vidhi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class EmailController {

    @Autowired
    @Qualifier("emailQualifier")
    EmailService emailService;

    //httpRequest for finding the number of unique email addresses
    @RequestMapping(method = RequestMethod.POST, value = "/finduniqueaddresses")
    public int findUniqueEmailAddress(@RequestBody String email){
        return emailService.findUniqueEmailAddress(email);
    }
}
