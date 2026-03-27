package com.example.ioc.service;

import org.springframework.stereotype.Component;

@Component("upiService")
public class UPIService implements PaymentService {

    @Override
    public String pay() {
        return "PAYMENT BY UPI";
    }
}
