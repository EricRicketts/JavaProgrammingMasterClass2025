package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Meal {

    private Item burger;
    private Item drink;
    private Item side;

    public Meal() {
        burger = new Item (
            BurgerMeatType.GROUND_HAMBURGER.toString(),
            BurgerSize.MEDIUM.toString(),
            new BigDecimal("2.55")
        );
        drink = new Item(
            Drink.COKE_MEDIUM.getName(),
            Drink.COKE_MEDIUM.getType(),
            Drink.COKE_MEDIUM.getPrice()
        );
        side = new Item(
            Side.FRIES_MEDIUM.getName(),
            Side.FRIES_MEDIUM.getType(),
            Side.FRIES_MEDIUM.getPrice()
        );
    }
    public Item getBurger() {
        return burger;
    }

    public void setBurger(Item burger) {
        this.burger = burger;
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

    @Override
    public String toString() {
        return "%10s%15s%10s".formatted(burger, drink, side);
    }

    public class Item {

        private String name;
        private String type;
        private BigDecimal price;

        public Item(
            String name,
            String type,
            BigDecimal price) {
            this.name = name;
            this.type = type;
            this.price = price.setScale(2, RoundingMode.HALF_UP);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price.setScale(2, RoundingMode.HALF_UP);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || (this.getClass() != obj.getClass())) return false;
            Item other = (Item) obj;
            return  Objects.equals(this.name, other.name) &&
                    Objects.equals(this.type, other.type) &&
                    Objects.equals(this.price, other.price);

        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name, this.type, this.price);
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, price);
        }
    }
}
