package com.buildrun.creditcardservice.Factory;

import com.buildrun.creditcardservice.domain.Customer;

public class CustomerFactory {

    public static Customer build() {
        return   new Customer(
                "Joel Langa",
                "123.456.89",
                3000.0,
                1000);
    }

    public static  Customer build(Double income){
        return   new Customer(
                "Joel Langa",
                "123.456.89",
                income,
                1000);
    }

    public static  Customer build(Integer score){
        return   new Customer(
                "Joel Langa",
                "123.456.89",
                3000.0,
                score);
    }


}
