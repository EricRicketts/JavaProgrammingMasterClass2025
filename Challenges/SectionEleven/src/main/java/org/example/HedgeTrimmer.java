package org.example;

import java.math.BigDecimal;

public class HedgeTrimmer extends ProductForSale {

    public HedgeTrimmer(String type, String description, BigDecimal price) {
        super(type, description, price);
    }

    @Override
    public String showDetails() {
        return "Type: " + this.getType() + " Price: " + this.getPrice() +
            " Description: " + this.getDescription();
    };
}
