package org.example;

import java.math.BigDecimal;

public class Blower extends ProductForSale {

    public Blower(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + " Price: " + this.getPrice() +
        " Description: " + this.getDescription();
    };
}