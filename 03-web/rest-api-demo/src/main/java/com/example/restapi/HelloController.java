package com.example.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "HELLO WORLD";
    }

    @GetMapping("/student")
    public String student() {
        return "HELLO STUDENT";
    }

    @GetMapping("/java")
    public String javaDemo() {
        return "JAVA IS WORKING";
    }
}

