package com.converter;

import java.util.Scanner;

public class Program {
    protected Program() {
    }

    public static Program start() {
        return new Program();
    }

    public void converter()
    {
        System.out.println(" ");
        System.out.println("CONVERTER v0.1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please write the currency code which you want to convert (e.g USD): ");
        Currency from = new Currency(scanner.nextLine());
        System.out.print("Write new currency (e.g. EUR): ");
        Currency to = new Currency(scanner.nextLine());
        System.out.print("And the amount of money that you want to convert (e.g. 25.5): ");
        from.setAmount(scanner.nextDouble());
        Currency converted = (new Converter(from)).convert(to).getConverted();
        System.out.println("Your converted money: " + converted.getAmount() + " " + converted.getCurrency());
    }
}
