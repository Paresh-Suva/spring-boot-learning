package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetterInjectionController {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/setter")
    public String setterInjection() {
        greetingService.greet();
        return "SETTER INJECTION WORKING";
    }
}
