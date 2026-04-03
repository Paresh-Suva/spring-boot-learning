package com.example.annotations;

import org.springframework.stereotype.Repository;

//  DATA ACCESS STYLE CLASS IN SPRING...
@Repository
// @Repository : CREATE OBJECT OF THIS CLASS...
// It IS LIKE @COMPONENT BUT MARKS THIS AS REPOSITORY FOR READABILITY...
public class RepositoryExample {

    public String work() {
        return "WORKING";
    }
}
