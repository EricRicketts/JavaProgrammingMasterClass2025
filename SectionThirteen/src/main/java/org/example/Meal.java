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
        return this.getBurger().getPrice().multiply(this.getConversionRate())
            .add(this.getDrink().getPrice().multiply(this.getConversionRate()))
            .add(this.getSide().getPrice().multiply(this.getConversionRate()));
    }

    @Override
    public String toString() {
        String mealItems = "%sPrice: %.2f%nDrink:%nType: %s%nPrice: %.2f%nSide:%nType: %s%nPrice: %.2f%n"
            .formatted(
            burger, burger.getPrice().multiply(this.getConversionRate()),
            drink, drink.getPrice().multiply(this.getConversionRate()),
            side, side.getPrice().multiply(this.getConversionRate()));
        String total = "Total Price: %.2f".formatted(getTotalPrice());

        return mealItems + total;
    }
}
