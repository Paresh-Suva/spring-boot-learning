package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES HTTP REQUESTS AND SHOWS COMMON SPRING ANNOTATIONS.
@RestController
// @RestController TELLS SPRING THIS CLASS IS A WEB CONTROLLER AND RETURNS DATA DIRECTLY.
// SPRING CREATES ONE OBJECT OF THIS CLASS WHEN THE APP STARTS.
public class AnnotationController {

    // THIS VARIABLE WILL HOLD THE ComponentExample OBJECT THAT SPRING CREATES.
    @Autowired
    // @Autowired TELLS SPRING TO FIND ComponentExample BEAN AND PUT IT IN THIS VARIABLE.
    private ComponentExample componentExample;

    // THIS VARIABLE WILL HOLD THE ServiceExample OBJECT THAT SPRING CREATES.
    @Autowired
    // @Autowired TELLS SPRING TO FIND ServiceExample BEAN AND PUT IT IN THIS VARIABLE.
    private ServiceExample serviceExample;

    // THIS VARIABLE WILL HOLD THE RepositoryExample OBJECT THAT SPRING CREATES.
    @Autowired
    // @Autowired TELLS SPRING TO FIND RepositoryExample BEAN AND PUT IT IN THIS VARIABLE.
    private RepositoryExample repositoryExample;

    // WHEN USER OPENS /component IN BROWSER OR POSTMAN, SPRING CALLS THIS METHOD.
    @GetMapping("/component")
    public String component() {
        // THIS LINE CALLS work() METHOD ON ComponentExample CLASS.
        String result = componentExample.work();
        // THIS LINE RETURNS A SIMPLE MESSAGE THAT INCLUDES THE RESULT FROM THE COMPONENT.
        return "COMPONENT ENDPOINT: " + result;
    }

    // WHEN USER OPENS /service IN BROWSER OR POSTMAN, SPRING CALLS THIS METHOD.
    @GetMapping("/service")
    public String service() {
        // THIS LINE CALLS work() METHOD ON ServiceExample CLASS.
        String result = serviceExample.work();
        // THIS LINE RETURNS A SIMPLE MESSAGE THAT INCLUDES THE RESULT FROM THE SERVICE.
        return "SERVICE ENDPOINT: " + result;
    }

    // WHEN USER OPENS /repository IN BROWSER OR POSTMAN, SPRING CALLS THIS METHOD.
    @GetMapping("/repository")
    public String repository() {
        // THIS LINE CALLS work() METHOD ON RepositoryExample CLASS.
        String result = repositoryExample.work();
        // THIS LINE RETURNS A SIMPLE MESSAGE THAT INCLUDES THE RESULT FROM THE REPOSITORY.
        return "REPOSITORY ENDPOINT: " + result;
    }
}
