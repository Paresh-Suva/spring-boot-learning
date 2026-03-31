package com.example.annotations;

import org.springframework.stereotype.Service;

// THIS CLASS IS A SIMPLE EXAMPLE OF A SERVICE LAYER CLASS IN SPRING.
@Service
// @Service TELLS SPRING TO CREATE OBJECT OF THIS CLASS.
// @Service IS LIKE @Component BUT MARKS THIS AS A SERVICE FOR READABILITY.
// SPRING AUTOMATICALLY MANAGES THIS CLASS.
public class ServiceExample {

    // THIS METHOD RETURNS A HARDCODED STRING TO SHOW THE CLASS IS USED.
    public String work() {
        // THIS LINE RETURNS THE SIMPLE MESSAGE "WORKING".
        return "WORKING";
    }
}
