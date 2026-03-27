package com.example.beanlifecycle.controller;

import com.example.beanlifecycle.component.MyBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanLifecycleController {

    private final MyBean myBean;

    public BeanLifecycleController(MyBean myBean) {
        this.myBean = myBean;
    }

    @GetMapping("/test")
    public String test() {
        myBean.toString();
        return "BEAN LIFECYCLE DEMO WORKING";
    }
}
