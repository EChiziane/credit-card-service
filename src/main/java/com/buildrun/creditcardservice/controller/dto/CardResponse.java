package com.buildrun.creditcardservice.controller.dto;

import com.buildrun.creditcardservice.domain.CreditCardType;

public record CardResponse(CreditCardType type,Double score, Double income) {
}
