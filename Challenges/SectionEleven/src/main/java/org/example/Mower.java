package org.example;

import java.math.BigDecimal;

public class Mower extends ProductForSale {

    public Mower(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + " Price: " + this.getPrice() +
            " Description: " + this.getDescription();
    };
}
