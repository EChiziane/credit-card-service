package com.buildrun.creditcardservice.domain;

public class Customer {
    String name;
    String cpf;
    Double income;
    Integer score;

    public Customer(String name, String cpf, Double income, Integer score) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.score = score;
    }

public boolean isIncomeEqualOrLowerThan(Double value){return income <= value; }
    public boolean isIncomeEqualOrGreaterThan(Double value){return income >= value; }
    public boolean isIncomeBetween(double minValue, double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean isScoreGreaterThan(Double value){return score > value; }
    public Double getIncome(){return income;}
    public  Integer getScore(){return score;}

}
