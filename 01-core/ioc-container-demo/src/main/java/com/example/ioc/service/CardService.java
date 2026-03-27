package com.example.ioc.service;

import org.springframework.stereotype.Component;

@Component("cardService")
public class CardService implements PaymentService {

    @Override
    public String pay() {
        return "PAYMENT BY CARD";
    }
}
