package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Burger {

    private final String type;
    private final BigDecimal price;
    List<Topping> toppings = Arrays.asList(new Topping[3]);

    public Burger(String type, BigDecimal price){
        this.type = type.toLowerCase();
        switch(type) {
            case "small" -> this.price = new BigDecimal("6.00");
            case "medium" -> this.price = new BigDecimal("15.00");
            case "large" -> this.price = new BigDecimal("25.00");
            default -> this.price = price;
        }
    }

    public void addTopping(String type) {
        for (int i = 0; i < this.getToppings().size(); i++) {
            if (this.getToppings().get(i) == null) {
                this.getToppings().set(i, new Topping(type));
                this.sortToppings();
                break;
            }
        }
    }

    public void sortToppings() {
        this.toppings.sort(Comparator.nullsLast(Comparator.naturalOrder()));
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;

        Burger other = (Burger) object;

//        this.getToppings().sort(Comparator.nullsLast(Comparator.naturalOrder()));
//        other.getToppings().sort(Comparator.nullsLast(Comparator.naturalOrder()));
        return Objects.equals(this.getPrice(), other.getPrice()) &&
            Objects.equals(this.getType(), other.getType()) &&
            Objects.equals(this.getToppings(), other.getToppings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getType(), this.getPrice(), this.getToppings());
    }
}
