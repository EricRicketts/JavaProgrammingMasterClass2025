package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Topping implements Comparable<Topping> {
    // Note declare a class Item and have Topping inherit from it.

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Topping other = (Topping) obj;

        return Objects.equals(this.getType(), other.getType()) &&
            Objects.equals(this.getPrice(), other.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getType(), this.getPrice());
    }

    @Override
    public int compareTo(Topping other) {
        return this.getType().compareTo(other.getType());
    }
}