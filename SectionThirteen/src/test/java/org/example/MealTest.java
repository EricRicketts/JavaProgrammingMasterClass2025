package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {

    private Meal meal;
    private Meal.Item expectedBurger, expectedDrink, expectedSide;

    @BeforeEach
    public void setUp() {
        meal = new Meal();
        expectedBurger = meal.new Item(
            "burger",
            BurgerName.GROUND_HAMBURGER.toString(),
            BurgerType.MEDIUM.toString(),
            new BigDecimal("2.55")
        );
        expectedDrink = meal.new Item(
            "drink",
            Drink.COKE_MEDIUM.getName(),
            Drink.COKE_MEDIUM.getType(),
            Drink.COKE_MEDIUM.getPrice()
        );
        expectedSide = meal.new Item(
            "side",
            Side.FRIES_MEDIUM.getName(),
            Side.FRIES_MEDIUM.getType(),
            Side.FRIES_MEDIUM.getPrice()
        );
    }

    @Nested
    @DisplayName("test meal getters")
    class TestMealGetters {

        @Test
        public void testMealGetBurger() {
            Meal.Item mealBurger = meal.getBurger();
            assertEquals(expectedBurger, mealBurger);
        }

        @Test
        public void testMealGetDrink() {
            Meal.Item mealDrink = meal.getDrink();
            assertEquals(expectedDrink, mealDrink);
        }

        @Test
        public void testMealGetSide() {
            Meal.Item mealSide = meal.getSide();
            assertEquals(expectedSide, mealSide);
        }
    }

    @Nested
    @DisplayName("test get meal price")
    class TestGetMealPrice {

        @Test
        public void testMealGetSubTotal() {
            BigDecimal expected = new BigDecimal("7.13");
            BigDecimal result = meal.calculateSubTotalPrice();

            assertEquals(expected, result);
        }

        @Test
        public void testMealGetTax() {
            BigDecimal expected = new BigDecimal("0.36");
            BigDecimal result = meal.calculateTax();

            assertEquals(expected, result);
        }

        @Test
        public void testGetMealFinalPrice() {
            BigDecimal expected = new BigDecimal("7.49");
            BigDecimal result = meal.calculateTotalPrice();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Meal toString()")
    class TestMealToString {

        @Test
        public void testMealToString() {
            String expected = """
                Burger:
                Name: GROUND_HAMBURGER
                Type: MEDIUM
                Price: $2.55
                
                Drink: Coke
                Type: Medium
                Price: $2.59
                
                Side: Fries
                Type: Medium
                Price: $1.99
                
                SubTotal: $7.13
                Tax: $0.36
               
                Total: $7.49
                """;
            String result = meal.toString();

            assertEquals(expected, result);
        }
    }

}
