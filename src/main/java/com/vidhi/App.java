package com.vidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//To find the unique email addresses count, following will be the endpoint while running locally http://localhost:8080/api/finduniqueaddresses

@SpringBootApplication
public class App {
    public static void main(String[] args){
        //Application starts from here
        SpringApplication.run(App.class, args);
    }
}
