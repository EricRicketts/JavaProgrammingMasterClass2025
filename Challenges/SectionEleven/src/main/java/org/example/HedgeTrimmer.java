package org.example;

import java.math.BigDecimal;

public class HedgeTrimmer extends ProductForSale {

    public HedgeTrimmer(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + "\n" + "Price: " + this.getPrice() + "\n" +
            "Description: " + this.getDescription() + "\n";
    };
}
