package org.example;

public class Drink {

    private final String type, size;
    private final double price;
    public Drink(String type, String size) {
        this.type = type.toLowerCase();
        this.size = size.toLowerCase();
        switch (this.size) {
            case "small" -> this.price = 1.20;
            case "medium" -> this.price = 2.60;
            case "large" -> this.price = 3.20;
            default -> this.price = 2.20;
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
