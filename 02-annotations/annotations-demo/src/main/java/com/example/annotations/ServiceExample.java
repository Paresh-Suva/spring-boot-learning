package com.example.annotations;

import org.springframework.stereotype.Service;

@Service
// @Service : CREATE OBJECT OF THIS CLASS
// SPRING AUTOMATICALLY MANAGES THIS CLASS.
public class ServiceExample {

    public String work() {
        return "WORKING";
    }
}
