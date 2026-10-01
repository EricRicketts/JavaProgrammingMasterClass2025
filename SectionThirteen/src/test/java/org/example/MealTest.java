package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Nested
    @DisplayName("test Burger toppings")
    class TestBurgerToppings {

        @Test
        public void testAddToppingsSingle() {
            meal.addToppings("cheese");
            String expected = """
                Burger:
                Name: GROUND_HAMBURGER
                Type: MEDIUM
                Price: $2.55
                
                Topping:
                Name: CHEESE
                Type: TOPPING
                Price: $1.25
                
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
            assertEquals(expected, meal.toString());
        }

        @Test
        public void testAddToppingsMultipleAndCaseInsensitive() {
            meal.addToppings("bacon", "avocado", "pickles");
            String expected = """
                Burger:
                Name: GROUND_HAMBURGER
                Type: MEDIUM
                Price: $2.55
                
                Topping:
                Name: BACON
                Type: TOPPING
                Price: $2.15
                
                Topping:
                Name: AVOCADO
                Type: TOPPING
                Price: $1.50
                
                Topping:
                Name: PICKLES
                Type: TOPPING
                Price: $1.15
                
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
            assertEquals(expected, meal.toString());
        }

        @Test
        public void testAddToppingsChaining() {
            Meal result = meal.addToppings("ketchup")
                .addToppings("mayo", "mustard");
            assertSame(meal, result);
        }

        @Test
        public void testAddInvalidToppingThrowsException() {
            assertThrows(IllegalArgumentException.class, () ->
                meal.addToppings("mushrooms")
            );
        }
    }

}
