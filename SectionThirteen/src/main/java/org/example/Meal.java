package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Meal {

    private BigDecimal price;
    private Burger burger;
    private Drink drink;
    private Side side;
    private List<Topping> toppings;
    private BigDecimal conversionRate;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Side getSide() {
        return this.side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Meal() {
        this(new BigDecimal("1.00"));
    }

    public Meal(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
        this.burger = new Burger(BurgerMeatType.ROUND,
            BurgerSize.MEDIUM, new BigDecimal("2.55")
        );
        this.drink = Drink.COKE_MEDIUM;
        this.side = Side.FRIES_MEDIUM;
        this.toppings = new ArrayList<>();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = this.getBurger().getPrice()
            .add(this.getDrink().getPrice())
            .add(this.getSide().getPrice());
        return total.multiply(this.getConversionRate());
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n26s$%.2f".formatted(burger,
            drink,
            side,
            "Total Due: ", getTotalPrice());
    }
}
