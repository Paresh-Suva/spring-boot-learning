package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructorInjectionController {

    private final GreetingService greetingService;

    public ConstructorInjectionController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/constructor")
    public String constructorInjection() {
        greetingService.greet();
        return "CONSTRUCTOR INJECTION WORKING";
    }
}
