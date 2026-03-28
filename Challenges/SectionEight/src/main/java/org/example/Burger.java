package org.example;

public class Burger {

    private final String type;
    private final double price;
    String[] toppings = new String[3];

    public Burger(String type, double price){
        this.type = type;
        if (type.equalsIgnoreCase("small")) {
            this.price = 6.00;
        } else if (type.equalsIgnoreCase("medium")) {
            this.price = 15.00;
        }
        else if (type.equalsIgnoreCase("large")) {
            this.price = 25.00;
        } else {
            this.price =  price;
        }
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String[] getToppings() {
        return toppings;
    }
}
