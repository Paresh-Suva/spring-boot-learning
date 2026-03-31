package com.example.annotations;

import org.springframework.stereotype.Component;

// THIS CLASS IS A SIMPLE EXAMPLE OF A SPRING-MANAGED COMPONENT.
@Component
// @Component TELLS SPRING TO CREATE ONE OBJECT OF THIS CLASS AND KEEP IT IN THE CONTAINER.
// SPRING AUTOMATICALLY MANAGES THIS CLASS.
public class ComponentExample {

    // THIS METHOD RETURNS A HARDCODED STRING TO SHOW THE CLASS IS USED.
    public String work() {
        // THIS LINE RETURNS THE SIMPLE MESSAGE "WORKING".
        return "WORKING";
    }
}
