package com.converter;

import java.util.Scanner;

public class Input {

    public static final int TYPE_STRING = 1;
    public static final int TYPE_DOUBLE = 2;
    private String result = "";
    private Double doubleResult = 0.0;
    protected String message;
    protected int type = TYPE_STRING;
    protected Scanner scanner;

    public Input(String message){
        this.scanner = new Scanner(System.in);
        this.message = message;
    }
    public static Input create(String message) {
        return new Input(message);
    }

    public Input run()
    {
        System.out.print(this.message);
        if (this.type == TYPE_DOUBLE)
        {
            this.doubleResult = this.scanner.nextDouble();
            return this;
        }
        this.result = this.scanner.nextLine();
        return this;
    }

    public double toDouble() {
        return this.doubleResult;
    }

    public String toString() {
        return this.result;
    }

    public Input type(int type)
    {
        this.type = type;
        return this;
    }
}
