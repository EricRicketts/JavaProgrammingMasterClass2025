package org.example;

import java.math.BigDecimal;

public class Burger {

    private final BurgerName name;
    private final BurgerType type;
    private final BigDecimal price;
    public Burger(BurgerName name, BurgerType type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public BurgerName getName() {
        return name;
    }

    public BurgerType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Burger:").append("\n")
            .append("Name: ").append(this.getName()).append("\n")
            .append("Type: ").append(this.getType()).append("\n")
            .append("Price: ").append("$").append(this.getPrice()).append("\n");

        return sb.toString();
    }
}
