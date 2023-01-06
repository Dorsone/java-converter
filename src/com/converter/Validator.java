package com.converter;

public class Validator {
    public String validateCurrency(String currency) throws Exception
    {
        try {
            return CurrencyConstants.valueOf(currency).toString();
        } catch (Exception exception) {
            throw new Exception("Invalid currency code");
        }
    }

    public double validateDouble(double amount) throws Exception
    {
        if (amount <= 0)
        {
            throw new Exception("Your number can't be smaller than 0");
        }
        return amount;
    }
}
