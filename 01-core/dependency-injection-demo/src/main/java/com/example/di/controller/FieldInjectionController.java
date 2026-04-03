package com.example.di.controller;

import com.example.di.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/field")
    public String fieldInjection() {
        greetingService.greet();
        return "FIELD INJECTION WORKING";
    }
}
