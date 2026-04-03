package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController: THIS CLASS IS A WEB CONTROLLER AND RETURNS DATA DIRECTLY
// SPRING CREATES ONE OBJECT OF THIS CLASS WHEN THE APP STARTS.
public class AnnotationController {

    @Autowired
    // @Autowired TELLS SPRING TO FIND ComponentExample BEAN AND PUT IT IN THIS VARIABLE...
    private ComponentExample componentExample;

    @Autowired
    private ServiceExample serviceExample;

    @Autowired
    private RepositoryExample repositoryExample;

    @GetMapping("/component")
    public String component() {
        String result = componentExample.work();
        return "COMPONENT ENDPOINT: " + result;
    }

    @GetMapping("/service")
    public String service() {
        String result = serviceExample.work();
        return "SERVICE ENDPOINT: " + result;
    }

    @GetMapping("/repository")
    public String repository() {
        String result = repositoryExample.work();
        return "REPOSITORY ENDPOINT: " + result;
    }
}
