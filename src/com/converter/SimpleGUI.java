package com.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {

    private final JTextField input1 = new JTextField("", 5);
    private final JTextField input2 = new JTextField("", 5);
    private final JTextField input3 = new JTextField("", 5);


    public SimpleGUI() {
        super("Currency Converter");
        this.setBounds(100, 100, 350, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 1, 5, 5));

        JLabel label1 = new JLabel("Write currency code which you want to convert (e.g USD):");
        container.add(label1);
        container.add(input1);
        JLabel label2 = new JLabel("Write new currency (e.g. EUR):");
        container.add(label2);
        container.add(input2);
        JLabel label3 = new JLabel("Amount of money that you want to convert (e.g. 25.5):");
        container.add(label3);
        container.add(input3);

        JButton button = new JButton("Convert");
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        protected String from;
        protected String to;
        protected double amount;

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                this.validateInputs();

                Currency converted = this.convert();
                String message = "Your converted money: " + converted.getAmount() + " " + converted.getCurrency();

                JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            }

        }

        protected Currency convert()
        {
            Currency fromCurrency = new Currency(this.from).setAmount(this.amount);
            Currency toCurrency = new Currency(this.to);
            return new Converter(fromCurrency).convert(toCurrency).getConverted();
        }
        protected void validateInputs() throws Exception {
            Validator validator = new Validator();
            this.from = validator.validateCurrency(input1.getText().toUpperCase());
            this.to = validator.validateCurrency(input2.getText().toUpperCase());
            this.amount = validator.validateDouble(input3.getText().toLowerCase());
        }
    }

}
