package com.example.annotations;

import org.springframework.stereotype.Component;

// SPRING-MANAGED COMPONENT.
@Component
// @Component:  CREATE ONE OBJECT OF THIS CLASS AND KEEP IT IN THE CONTAINER...
// SPRING AUTOMATICALLY MANAGES THIS CLASS.
public class ComponentExample {

    public String work() {
        return "WORKING";
    }
}
