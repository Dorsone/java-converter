package com.converter;

import java.util.Objects;

public class Program {
    protected Program() {
        this.validator = new Validator();
    }

    protected Validator validator;
    protected Currency from;
    protected Currency to;
    protected double amount;

    public static Program start() {
        return new Program();
    }

    public void converter()
    {
        System.out.println(" ");
        System.out.println("CONVERTER v0.1");
        this.currencyInputs();
        this.amountInput();
        Currency converted = (new Converter(from)).convert(Objects.requireNonNull(to)).getConverted();
        System.out.println("Your converted money: " + converted.getAmount() + " " + converted.getCurrency());
    }

    protected void amountInput(){
        try {
            double temp = Input.create("And the amount of money that you want to convert (e.g. 25.5): ").type(Input.TYPE_DOUBLE).run().toDouble();
            this.from.setAmount(this.validator.validateDouble(temp));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.amountInput();
        }
    }

    protected void currencyInputs() {
        try {
            String temp = null;

            temp = Input.create("Please write the currency code which you want to convert (e.g USD): ").run().toString();
            Currency from = new Currency(this.validator.validateCurrency(temp));

            temp = Input.create("Write new currency (e.g. EUR): ").run().toString();
            Currency to = new Currency(this.validator.validateCurrency(temp));

            this.from = from;
            this.to = to;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.currencyInputs();
        }
    }
}
