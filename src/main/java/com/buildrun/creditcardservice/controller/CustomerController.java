package com.buildrun.creditcardservice.controller;

import com.buildrun.creditcardservice.CardService;
import com.buildrun.creditcardservice.controller.dto.CustomerCardRequest;
import com.buildrun.creditcardservice.controller.dto.CustomerCardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("Cards")
public class CustomerController {

    private final CardService cardService;

    public CustomerController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/customer-cards")
    public ResponseEntity<CustomerCardResponse> addCustomer(@RequestBody CustomerCardRequest cardRequest) {
        var cardResponse= cardService.checkCardAvailability(cardRequest);

        return ResponseEntity.ok().body(cardResponse);
    }
}
