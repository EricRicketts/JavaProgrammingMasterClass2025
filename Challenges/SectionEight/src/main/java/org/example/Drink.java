package org.example;

public class Drink {

    private final String type, size;
    private final double price;
    public Drink(String type, String size) {
        this.type = type;
        this.size = size.toLowerCase();
        if (size.equalsIgnoreCase("small")) {
            this.price = 1.20;
        } else if (size.equalsIgnoreCase("medium")) {
            this.price = 2.60;
        } else if (size.equalsIgnoreCase("large")) {
            this.price = 3.20;
        } else {
            this.price = 2.20;
        }
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
