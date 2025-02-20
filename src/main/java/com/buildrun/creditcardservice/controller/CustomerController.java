package com.buildrun.creditcardservice.controller;

import com.buildrun.creditcardservice.controller.dto.CustomerCardRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerController {

    @PostMapping("/customer-cards")
    public ResponseEntity<CostumerCardResponse> addCustomer(@RequestBody CustomerCardRequest cardRequest) {
        var cardResponse=cardService.

        return null;
    }
}
