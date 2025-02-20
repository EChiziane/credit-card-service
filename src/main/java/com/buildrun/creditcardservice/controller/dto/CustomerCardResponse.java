package com.buildrun.creditcardservice.controller.dto;

import java.util.List;

public record CustomerCardResponse (String customer, List<CardResponse> cards){
}
