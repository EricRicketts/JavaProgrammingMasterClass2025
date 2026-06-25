package org.example;

import java.math.BigDecimal;

public class Drink {

    private final String type;
    private final BigDecimal price;
    private String size;
    public Drink(String type, String size) {
        this.type = type.toLowerCase();
        this.size = size.toLowerCase();
        switch (this.size) {
            case "small" -> this.price = new BigDecimal("1.20");
            case "medium" -> this.price = new BigDecimal("2.60");
            case "large" -> this.price = new BigDecimal("3.20");
            default -> this.price = new BigDecimal("2.20");
        }
    }

    public void setSize(String size) {
        this.size = size.toLowerCase();
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }
}