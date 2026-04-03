package com.example.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES HTTP REQUESTS.
// @RESTCONTROLLER TELLS SPRING TO RETURN DATA DIRECTLY.
// SPRING CREATES THIS CONTROLLER OBJECT WHEN APP STARTS.
@RestController
public class RequestController {

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR /NAME GET REQUEST.
    @GetMapping("/name")
    public String name() {
        return "HELLO USER";
    }

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR /NAME/{USERNAME}.
    // @PATHVARIABLE TELLS SPRING TO READ USERNAME FROM THE URL.
    @GetMapping("/name/{username}")
    public String nameWithUsername(@PathVariable String username) {
        return "HELLO " + username;
    }

    // @REQUESTPARAM : READ VALUE FROM THE URL QUERY...
    @GetMapping("/age")
    public String age(@RequestParam int value) {
        return "AGE IS " + value;
    }

    // @POSTMAPPING : THIS METHOD RUNS FOR /STUDENT POST REQUEST
    // @REQUESTBODY : TO READ JSON BODY AND FILL STUDENT OBJECT
    @PostMapping("/student")
    public String student(@RequestBody Student student) {
        student.getName();
        return "STUDENT RECEIVED";
    }
}

