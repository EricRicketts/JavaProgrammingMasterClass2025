package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Meal {

    private final Burger burger;
    private final Item drink;
    private final Item side;
    private final BigDecimal taxRate = new BigDecimal("0.05");

    public Meal() {
        burger = new Burger();
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

        return burger.toString() +
            "\n" +
            drink.toString() +
            "\n" +
            side.toString() +
            "\n" +
            "SubTotal: " + "$" + calculateSubTotalPrice() +
            "\n" +
            "Tax: " + "$" + calculateTax() +
            "\n\n" +
            "Total: " + "$" + calculateTotalPrice() + "\n";
    }

    public Meal addToppings(String ...selectedToppings) {
        burger.addToppings(selectedToppings);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (this.getClass() != obj.getClass())) return false;
        Meal other = (Meal) obj;
        return  Objects.equals(this.burger, other.burger) &&
            Objects.equals(this.drink, other.drink) &&
            Objects.equals(this.side, other.side);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.burger, this.drink, this.side);
    }

    private static class Item {

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
            return String.format("%s:\nName: %s\nType: %s\nPrice: $%s\n",
                kind.substring(0, 1).toUpperCase() + kind.substring(1),
                name,
                type,
                price);
            }
        }

    private static class Burger extends Item {

        private enum Extras {
            AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private BigDecimal getPrice() {
                return switch (this) {
                    case AVOCADO -> new BigDecimal("1.50");
                    case BACON -> new BigDecimal("2.15");
                    case CHEESE -> new BigDecimal("1.25");
                    case KETCHUP, MAYO, MUSTARD -> new BigDecimal("1.00");
                    case PICKLES -> new BigDecimal("1.15");
                };
            }
        }

        private final List<Item> toppings = new ArrayList<>();

        Burger() {
            super(
                "Burger",
                BurgerName.GROUND_HAMBURGER.toString(),
                BurgerType.MEDIUM.toString(),
                new BigDecimal("2.55")
            );
        }

        private void addToppings(String... selectedToppings) {
            for (String selectedTopping : selectedToppings) {
                try {
                    Extras topping =
                        Extras.valueOf(selectedTopping.toUpperCase());
                    toppings.add(
                        new Item(
                            "Topping",
                            topping.name(),
                            "TOPPING",
                            topping.getPrice()
                        )
                    );
                } catch (IllegalArgumentException ie) {
                    throw new IllegalArgumentException(ie.getMessage());
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings) {
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }
}