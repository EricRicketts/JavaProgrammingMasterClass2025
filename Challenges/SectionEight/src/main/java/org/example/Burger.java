package org.example;

public class Burger {

    String type;
    double price;
    String[] toppings = new String[3];

    public Burger(String type, double price){
        this.type = type;
        this.price = price;
    }
}
