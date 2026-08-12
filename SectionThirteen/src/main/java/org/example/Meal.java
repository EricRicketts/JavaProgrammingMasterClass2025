package org.example;

import java.math.BigDecimal;

public class Meal {

    private BigDecimal price;
    private Burger burger;
    private Item drink;
    private Item side;
    private BigDecimal conversionRate;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Item getDrink() {
        return drink;
    }

    public void setDrink(Item drink) {
        this.drink = drink;
    }

    public Item getSide() {
        return side;
    }

    public void setSide(Item side) {
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
        this.drink = new Item("Coke", "Medium", new BigDecimal("1.50"));
        this.side = new Item("Fries", "Small", new BigDecimal("2.00"));
    }

    public BigDecimal getTotal() {
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
            "Total Due: ", getTotal());
    }

    private class Item {
        private String name;
        private String type;
        private BigDecimal price;

        public Item(String name, String type) {
            // The last argument is a statement for price.  Note the inner class can access
            //  an attribute of the outer class directly; it does not need to call the
            // getter getBase().
            this(name, type, type.equals("burger") ? Meal.this.price : new BigDecimal("0.00"));
        }

        public Item(String name, String type, BigDecimal price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public BigDecimal getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, price);
        }
    }
}
