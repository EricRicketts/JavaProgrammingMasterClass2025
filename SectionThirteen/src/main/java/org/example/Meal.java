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
            "burger",
            BurgerName.GROUND_HAMBURGER.toString(),
            BurgerType.MEDIUM.toString(),
            new BigDecimal("2.55")
        );
        drink = new Item(
            "drink",
            Drink.COKE_MEDIUM.getName(),
            Drink.COKE_MEDIUM.getType(),
            Drink.COKE_MEDIUM.getPrice()
        );
        side = new Item(
            "side",
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
        StringBuilder invoice = new StringBuilder();
        invoice.append(
            burger.toString())
            .append("\n")
            .append(drink.toString())
            .append("\n")
            .append(side.toString())
            .append("\n")
            .append("SubTotal: ").append("$").append(calculateSubTotalPrice())
            .append("\n")
            .append("Tax: ").append("$").append(calculateTax())
            .append("\n\n")
            .append("Total: ").append("$").append(calculateTotalPrice()).append("\n");

        return invoice.toString();
    }

    public class Item {

        private final String kind;
        private final String name;
        private final String type;
        private final BigDecimal price;

        public Item(
            String kind,
            String name,
            String type,
            BigDecimal price) {
            this.kind = kind;
            this.name = name;
            this.type = type;
            this.price = price.setScale(2, RoundingMode.HALF_UP);
        }

        public String getKind() {
            return kind;
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
            StringBuilder sb = new StringBuilder();
            if (this.kind.equalsIgnoreCase("drink")) {
                sb.append("Drink: ").append(this.getName()).append("\n")
                    .append("Type: ").append(this.getType()).append("\n")
                    .append("Price: ").append("$").append(this.getPrice()).append("\n");

                return sb.toString();
            } else if (this.kind.equalsIgnoreCase("side")) {
                sb.append("Side: ").append(this.getName()).append("\n")
                    .append("Type: ").append(this.getType()).append("\n")
                    .append("Price: ").append("$").append(this.getPrice()).append("\n");

                return sb.toString();
            } else {
                sb = sb.append("Burger:").append("\n")
                    .append("Name: ").append(this.getName()).append("\n")
                    .append("Type: ").append(this.getType()).append("\n")
                    .append("Price: ").append("$").append(this.getPrice()).append("\n");

                return sb.toString();
            }
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
    }
}
