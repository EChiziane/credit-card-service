package com.buildrun.creditcardservice.domain;

public class Card {
    private Customer customer;

    public Card(Customer customer) {
        this.customer = customer;
    }

public boolean isBasicCreditCardAvailable(){

        return customer.isIncomeEqualOrLowerThan(2000.0)&&
        customer.isScoreGreaterThan(500.0);
       }


    public boolean isGoldCreditCardAvailable(){

        return customer.isIncomeEqualOrLowerThan(5000.0)
                && customer.isIncomeEqualOrGreaterThan(2000.0)
               && customer.isScoreGreaterThan(600.0);
    }


    public boolean isPlatinumCreditCardAvailable(){

        return customer.isIncomeEqualOrGreaterThan(5000.0)&&
                customer.isScoreGreaterThan(750.0);
    }

    public int getPersonalScore(){

    }


}
