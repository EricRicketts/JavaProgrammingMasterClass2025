package org.example;

import java.math.BigDecimal;

public class Blower extends ProductForSale {

    public Blower(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
        "Description: " + this.getDescription() + "\n";
    };
}