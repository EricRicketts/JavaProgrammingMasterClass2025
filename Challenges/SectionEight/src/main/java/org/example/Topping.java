package org.example;

import java.math.BigDecimal;

public class Topping {

    private final String type;
    private final BigDecimal price;

    public Topping(String type) {
        this.type = type.toLowerCase();
        switch(this.type) {
            case "lettuce" -> this.price = new BigDecimal("1.00");
            case "tomatoes" -> this.price = new BigDecimal("1.50");
            case "cheese" -> this.price = new BigDecimal("2.00");
            default -> this.price = new BigDecimal("0.50");
            }
        }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }
}