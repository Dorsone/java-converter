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

    public double validateDouble(String amount) throws Exception
    {
        try{
            return Double.parseDouble(amount);
        } catch(Exception e) {
            throw new Exception("Invalid double");
        }
    }
}
