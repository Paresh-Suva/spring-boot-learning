package com.example.ioc.controller;

import com.example.ioc.service.CardService;
import com.example.ioc.service.UPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES PAYMENT API REQUESTS.
@RestController
public class PaymentController {

    private final UPIService upiService;
    private final CardService cardService;

    // SPRING CREATES UPIService AND CardService OBJECTS.
    public PaymentController(UPIService upiService, CardService cardService) {
        this.upiService = upiService;
        this.cardService = cardService;
    }

    @GetMapping("/upi")
    public String upiPayment() {
        return upiService.pay();
    }

    @GetMapping("/card")
    public String cardPayment() {
        return cardService.pay();
    }
}
