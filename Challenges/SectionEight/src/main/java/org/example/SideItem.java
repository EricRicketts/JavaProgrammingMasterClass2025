package org.example;

import java.math.BigDecimal;

public class SideItem {

    private final String type;
    private final BigDecimal price;

    public SideItem(String type) {
        this.type = type.toLowerCase();
        switch (this.type) {
            case "fries" -> this.price = new BigDecimal("2.50");
            case "onion rings" -> this.price = new BigDecimal("3.00");
            case "salad" -> this.price = new BigDecimal("10.00");
            default -> this.price = new BigDecimal("4.00");
        }
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
