package com.example.annotations;

import org.springframework.stereotype.Repository;

// THIS CLASS IS A SIMPLE EXAMPLE OF A DATA ACCESS STYLE CLASS IN SPRING.
@Repository
// @Repository TELLS SPRING TO CREATE OBJECT OF THIS CLASS.
// @Repository IS LIKE @COMPONENT BUT MARKS THIS AS REPOSITORY FOR READABILITY.
// SPRING AUTOMATICALLY MANAGES THIS CLASS.
public class RepositoryExample {

    // THIS METHOD RETURNS A HARDCODED STRING TO SHOW THE CLASS IS USED.
    public String work() {
        // THIS LINE RETURNS THE SIMPLE MESSAGE "WORKING".
        return "WORKING";
    }
}
