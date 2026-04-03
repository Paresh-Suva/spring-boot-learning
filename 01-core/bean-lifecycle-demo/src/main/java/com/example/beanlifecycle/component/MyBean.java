package com.example.beanlifecycle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @PostConstruct
    public void init() {
        System.out.println("BEAN CREATED");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BEAN DESTROYED");
    }
}
