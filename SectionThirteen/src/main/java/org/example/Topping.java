package org.example;

import java.math.BigDecimal;

public enum Topping {

    LETTUCE(new BigDecimal("1.50")),
    TOMATO(new BigDecimal("2.50")),
    ONION(new BigDecimal("1.00")),
    RELISH(new BigDecimal("0.75"));

    private final BigDecimal price;
    Topping(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
