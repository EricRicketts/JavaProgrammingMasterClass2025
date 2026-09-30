package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Meal {

    private final Item burger;
    private final Item drink;
    private final Item side;
    private final BigDecimal taxRate = new BigDecimal("0.05");

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

    public Item getDrink() {
        return drink;
    }

    public Item getSide() {
        return side;
    }

    public BigDecimal calculateSubTotalPrice() {
        return this.burger.getPrice()
            .add(this.drink.getPrice())
            .add(this.side.getPrice());
    }

    public BigDecimal calculateTax() {
        return calculateSubTotalPrice()
            .multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotalPrice() {
        return calculateSubTotalPrice().add(calculateTax());
    }

    @Override
    public String toString() {
        return "%10s%15s%10s".formatted(burger, drink, side);
    }

    public class Item {

        private final String name;
        private final String type;
        private final BigDecimal price;

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

        public String getType() {
            return type;
        }

        public BigDecimal getPrice() {
            return price;
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
