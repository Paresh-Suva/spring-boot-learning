package com.example.di.service;

import org.springframework.stereotype.Service;

// THIS MAKES THIS CLASS A SPRING-MANAGED SERVICE OBJECT.
@Service
public class SimpleGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hello Student";
    }
}
