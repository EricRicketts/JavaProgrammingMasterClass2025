package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {

    private Meal meal;

    @BeforeEach
    public void setUp() {
        meal = new Meal();
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
                
                Drink:
                Name: Coke
                Type: Medium
                Price: $2.59
                
                Side:
                Name: Fries
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
