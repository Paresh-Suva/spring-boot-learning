package com.example.di.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hello Student";
    }
}
