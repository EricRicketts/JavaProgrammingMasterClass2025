package org.example;

public class SideItem {

    private final String type;
    private final double price;

    public SideItem(String type) {
        this.type = type.toLowerCase();
        switch (type) {
            case "fries" -> this.price = 2.50;
            case "onion rings" -> this.price = 3.00;
            case "salad" -> this.price = 10.00;
            default -> this.price = 4.00;
        }
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
