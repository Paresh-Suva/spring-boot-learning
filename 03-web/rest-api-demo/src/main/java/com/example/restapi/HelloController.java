package com.example.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS IS A REST CONTROLLER.
// @RESTCONTROLLER TELLS SPRING THIS CLASS RETURNS DATA FOR HTTP.
// SPRING WILL CREATE ONE OBJECT OF THIS CONTROLLER AT APP START.
@RestController
public class HelloController {

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR GET REQUESTS.
    // THIS METHOD IS CALLED WHEN BROWSER OPENS /HELLO.
    @GetMapping("/hello")
    public String hello() {
        // THIS LINE BUILDS THE RESPONSE STRING.
        // THIS LINE RETURNS THE RESPONSE TO THE BROWSER.
        return "HELLO WORLD";
    }

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR GET REQUESTS.
    // THIS METHOD IS CALLED WHEN BROWSER OPENS /STUDENT.
    @GetMapping("/student")
    public String student() {
        // THIS LINE BUILDS THE RESPONSE STRING.
        // THIS LINE RETURNS THE RESPONSE TO THE BROWSER.
        return "HELLO STUDENT";
    }

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR GET REQUESTS.
    // THIS METHOD IS CALLED WHEN BROWSER OPENS /JAVA.
    @GetMapping("/java")
    public String javaDemo() {
        // THIS LINE BUILDS THE RESPONSE STRING.
        // THIS LINE RETURNS THE RESPONSE TO THE BROWSER.
        return "JAVA IS WORKING";
    }
}

