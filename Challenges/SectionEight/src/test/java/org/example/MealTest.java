package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {

    Meal firstMeal, secondMeal, thirdMeal, fourthMeal;
    String expected, result;

    @BeforeEach
    public void setUp() {
        firstMeal = new Meal(
                new Burger("large", new BigDecimal("13.00")),
                new Drink("Coke", "large"),
                new SideItem("fries"));

        secondMeal = new Meal(
                new Burger("small", new BigDecimal("13.00")),
                new Drink("Pepsi", "small"),
                new SideItem("onion rings"),
                "lettuce");

        thirdMeal = new Meal(
                new Burger("medium", new BigDecimal("13.00")),
                new Drink("Mountain Dow", "medium"),
                new SideItem("salad"),
                "lettuce", "tomatoes");

        fourthMeal = new Meal(
                new Burger("large", new BigDecimal("13.00")),
                new Drink("Dr Pepper", "large"),
                new SideItem("fries"),
                "lettuce", "tomatoes", "cheese");

    }

    @Nested
    @DisplayName("test all meal constructors")
    class TestAllMealConstructors {

        @Test
        public void testFirstMeal() {
            expected =
                "Burger: type: large, price: 25.00\n" +
                    "Drink: type: coke, price: 3.20\n" +
                    "Side: type: fries, price: 2.50\n" +
                    "Toppings:\n" + "Total Price: 30.70";
            result = firstMeal.getReceipt();
            assertEquals(expected, result);
        }

        @Test
        public void testSecondMeal() {
            expected =
                "Burger: type: small, price: 6.00\n" +
                    "Drink: type: pepsi, price: 1.20\n" +
                    "Side: type: onion rings, price: 3.00\n" +
                    "Toppings:\n" + "type: lettuce price: 1.00\n" + "Total Price: 11.20";
            result = secondMeal.getReceipt();
            assertEquals(expected, result);
        }

        @Test
        public void testThirdMeal() {
            expected =
                "Burger: type: medium, price: 15.00\n" +
                    "Drink: type: mountain dow, price: 2.60\n" +
                    "Side: type: salad, price: 10.00\n" +
                    "Toppings:\n" +
                    "type: lettuce price: 1.00\n" +
                    "type: tomatoes price: 1.50\n" +
                    "Total Price: 30.10";
            result = thirdMeal.getReceipt();
            assertEquals(expected, result);
        }

        @Test
        public void testFourthMeal() {
            expected =
                "Burger: type: large, price: 25.00\n" +
                    "Drink: type: dr pepper, price: 3.20\n" +
                    "Side: type: fries, price: 2.50\n" +
                    "Toppings:\n" +
                    "type: lettuce price: 1.00\n" +
                    "type: tomatoes price: 1.50\n" +
                    "type: cheese price: 2.00\n" +
                    "Total Price: 35.20";
            result = fourthMeal.getReceipt();
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test non receipt getters")
    class TestNonReceiptGetters {

        @Test
        public void testGetBurger() {
            List<String> toppings = new ArrayList<>(List.of(
                    "lettuce", "tomatoes", "cheese"
                ));
            Burger expectedBurger = new Burger("large", new BigDecimal("25.00"));
            for (int index = 0; index < 3; index++) {
                expectedBurger.addTopping(toppings.get(index));
            }
            Burger resultantBurger = fourthMeal.getBurger();

            assertEquals(expectedBurger, resultantBurger);
        }
    }
}
