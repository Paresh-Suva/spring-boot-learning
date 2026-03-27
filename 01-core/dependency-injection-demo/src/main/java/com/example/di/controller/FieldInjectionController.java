package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES HTTP REQUESTS FOR FIELD INJECTION DEMO.
@RestController
public class FieldInjectionController {

    // THIS VARIABLE STORES THE SERVICE OBJECT USED BY THIS CONTROLLER.
    @Autowired
    // SPRING CREATES OBJECT OF SimpleGreetingService AND PUTS IT IN THIS VARIABLE.
    private GreetingService greetingService;

    // WHEN USER CALLS /field, SPRING RUNS THIS METHOD.
    @GetMapping("/field")
    public String fieldInjection() {
        // THIS LINE CALLS greet() METHOD FROM SERVICE CLASS.
        greetingService.greet();
        // THIS LINE RETURNS SIMPLE RESPONSE TO BROWSER OR POSTMAN.
        return "FIELD INJECTION WORKING";
    }
}
