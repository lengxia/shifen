package com.jubeis.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class LoginJarApplication {

    @RequestMapping("/")
    public String home(){
        return ("hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(LoginJarApplication.class, args);
    }
}
