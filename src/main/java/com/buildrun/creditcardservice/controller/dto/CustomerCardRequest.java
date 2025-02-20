package com.buildrun.creditcardservice.controller.dto;

import com.buildrun.creditcardservice.domain.Customer;

public record CustomerCardRequest(String name, String cpf, Double income, Integer credit_score) {
public Customer toCustomer() {
    return  new Customer(name,
            cpf,
            income,
            credit_score);
}

}
