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
            BurgerMeatType.GROUND_HAMBURGER.toString(),
            BurgerSize.MEDIUM.toString(),
            new BigDecimal("2.55")
        );
        expectedDrink = meal.new Item(
            Drink.COKE_MEDIUM.getName(),
            Drink.COKE_MEDIUM.getType(),
            Drink.COKE_MEDIUM.getPrice()
        );
        expectedSide = meal.new Item(
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

}
