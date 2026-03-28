package org.example;

public class Topping {

    private String type;
    private final double price;

    public Topping(String type) {
        if (type.equalsIgnoreCase("lettuce")) {
            this.price = 1.00;
        } else if (type.equalsIgnoreCase("tomatoes")) {
            this.price = 1.50;
        } else if (type.equalsIgnoreCase("cheese")) {
            this.price = 2.00;
        } else {
            this.price = 0.50;
        }
    }
    public double getPrice() {
        return price;
    }
}
