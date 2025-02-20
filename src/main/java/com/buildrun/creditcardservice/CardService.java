package com.buildrun.creditcardservice;

import com.buildrun.creditcardservice.controller.dto.CardResponse;
import com.buildrun.creditcardservice.controller.dto.CustomerCardRequest;
import com.buildrun.creditcardservice.controller.dto.CustomerCardResponse;
import com.buildrun.creditcardservice.domain.Card;
import com.buildrun.creditcardservice.domain.CreditCardType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CardService {
    public CustomerCardResponse checkCardAvailability(CustomerCardRequest customerCardRequest) {
        var costumer = customerCardRequest.toCustomer();
        var card= new Card(costumer);

        List<CardResponse> cards = new ArrayList<>();

        if(card.isPlatinumCreditCardAvailable()){
            cards.add(new CardResponse(CreditCardType.PLATINUM, costumer.getIncome(),(double) costumer.getScore()));
        }

        if(card.isGoldCreditCardAvailable()){
            cards.add(new CardResponse(CreditCardType.GOLD, costumer.getIncome(),(double) costumer.getScore()));
        }

        if(card.isBasicCreditCardAvailable()){
            cards.add(new CardResponse(CreditCardType.BASIC, costumer.getIncome(),(double) costumer.getScore()));
        }

        return  new CustomerCardResponse(customerCardRequest.name(),cards);
    }
}
