package org.example;

import java.math.BigDecimal;

public class Mower extends ProductForSale {

    public Mower(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
            "Description: " + this.getDescription() + "\n";
    };
}
