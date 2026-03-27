package com.example.beanlifecycle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// THIS CLASS BECOMES A SPRING BEAN BECAUSE OF @Component.
@Component
public class MyBean {

    // SPRING RUNS THIS METHOD RIGHT AFTER CREATING MyBean OBJECT.
    @PostConstruct
    public void init() {
        // THIS LINE PRINTS MESSAGE TO CONSOLE WHEN BEAN IS CREATED.
        System.out.println("BEAN CREATED");
    }

    // SPRING RUNS THIS METHOD WHEN APPLICATION IS SHUTTING DOWN.
    @PreDestroy
    public void destroy() {
        // THIS LINE PRINTS MESSAGE TO CONSOLE BEFORE BEAN IS DESTROYED.
        System.out.println("BEAN DESTROYED");
    }
}
