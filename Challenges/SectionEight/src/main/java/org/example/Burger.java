package org.example;

import java.math.BigDecimal;

public class Burger {

    private final String type;
    private final BigDecimal price;
    Topping[] toppings = new Topping[3];

    public Burger(String type, BigDecimal price){
        Topping[] toppings = new Topping[3];
        this.type = type.toLowerCase();
        switch(type) {
            case "small" -> this.price = new BigDecimal("6.00");
            case "medium" -> this.price = new BigDecimal("15.00");
            case "large" -> this.price = new BigDecimal("25.00");
            default -> this.price = price;
        }
    }

    public void addTopping(String type) {
        for (int i = 0; i < this.getToppings().length; i++) {
            if (this.getToppings()[i] == null) {
                Topping topping = new Topping(type);
                this.getToppings()[i] = topping;
                break;
            }
        }
    }
    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Topping[] getToppings() {
        return toppings;
    }
}
