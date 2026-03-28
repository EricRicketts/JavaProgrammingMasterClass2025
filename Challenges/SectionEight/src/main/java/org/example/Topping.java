package org.example;

public class Topping {

    private final String type;
    private final double price;

    public Topping(String type) {
        this.type = type.toLowerCase();
        switch(this.type) {
            case "lettuce" -> this.price = 1.00;
            case "tomatoes" -> this.price = 1.50;
            case "cheese" -> this.price = 2.00;
            default -> this.price = 0.50;
            }
        }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}