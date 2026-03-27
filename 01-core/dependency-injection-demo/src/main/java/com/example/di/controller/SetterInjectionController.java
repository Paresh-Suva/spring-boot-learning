package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES HTTP REQUESTS FOR SETTER INJECTION DEMO.
@RestController
public class SetterInjectionController {

    // THIS VARIABLE HOLDS THE SERVICE OBJECT AFTER SETTER METHOD RUNS.
    private GreetingService greetingService;

    // SPRING CALLS THIS SETTER METHOD AND PASSES GreetingService OBJECT.
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        // THIS LINE SAVES PASSED OBJECT INTO CLASS VARIABLE.
        this.greetingService = greetingService;
    }

    // WHEN USER CALLS /setter, SPRING RUNS THIS METHOD.
    @GetMapping("/setter")
    public String setterInjection() {
        // THIS LINE CALLS greet() METHOD FROM SERVICE CLASS.
        greetingService.greet();
        // THIS LINE RETURNS SIMPLE RESPONSE TO BROWSER OR POSTMAN.
        return "SETTER INJECTION WORKING";
    }
}
