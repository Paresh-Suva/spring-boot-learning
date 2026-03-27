package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES HTTP REQUESTS FOR CONSTRUCTOR INJECTION DEMO.
@RestController
public class ConstructorInjectionController {

    // THIS VARIABLE STORES THE SERVICE OBJECT RECEIVED IN CONSTRUCTOR.
    private final GreetingService greetingService;

    // SPRING CREATES OBJECT OF GreetingService AND PASSES IT HERE.
    public ConstructorInjectionController(GreetingService greetingService) {
        // THIS LINE SAVES RECEIVED SERVICE OBJECT INTO CLASS VARIABLE.
        this.greetingService = greetingService;
    }

    // WHEN USER CALLS /constructor, SPRING RUNS THIS METHOD.
    @GetMapping("/constructor")
    public String constructorInjection() {
        // THIS LINE CALLS greet() METHOD FROM SERVICE CLASS.
        greetingService.greet();
        // THIS LINE RETURNS SIMPLE RESPONSE TO BROWSER OR POSTMAN.
        return "CONSTRUCTOR INJECTION WORKING";
    }
}
