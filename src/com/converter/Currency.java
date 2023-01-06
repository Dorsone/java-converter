package com.converter;

public class Currency {

    protected String currency;
    protected double amount = 0.0;
    public Currency(String currency)
    {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
}
