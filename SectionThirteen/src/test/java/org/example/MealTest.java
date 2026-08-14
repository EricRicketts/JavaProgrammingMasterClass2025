package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {

    private Meal firstMeal, secondMeal;

    @BeforeEach
    public void setUp() {
        firstMeal = new Meal();
        secondMeal = new Meal(new BigDecimal("0.50"));
    }

    @Nested
    @DisplayName("test first meal get burger meat type, size and price")
    class TestFirstMealBurgerMeatTypeSizeAndPrice {

        @Test
        public void testFirstMealGetBurgerMeatType() {
            assertEquals(BurgerMeatType.ROUND, firstMeal.getBurger().getMeatType());
        }

        @Test
        public void testFirstMealGetBurgerSize() {
            assertEquals(BurgerSize.MEDIUM, firstMeal.getBurger().getSize());
        }

        @Test
        public void testFirstMealGetBurgerPrice() {
            assertEquals(new BigDecimal("2.55"), firstMeal.getBurger().getPrice());
        }
    }

    @Nested
    @DisplayName("test set burger for meal")
    class TestFirstMealSetBurger {

        @Test
        public void testSetFirstMealBurger() {
            assertEquals(BurgerMeatType.ROUND, firstMeal.getBurger().getMeatType());
            assertEquals(BurgerSize.MEDIUM, firstMeal.getBurger().getSize());
            assertEquals(new BigDecimal("2.55"), firstMeal.getBurger().getPrice());

            firstMeal.setBurger(new Burger(BurgerMeatType.GRASS_FED, BurgerSize.LARGE, new BigDecimal("3.19")));

            assertEquals(BurgerMeatType.GRASS_FED, firstMeal.getBurger().getMeatType());
            assertEquals(BurgerSize.LARGE, firstMeal.getBurger().getSize());
            assertEquals(new BigDecimal("3.19"), firstMeal.getBurger().getPrice());
        }
    }

    @Nested
    @DisplayName("test set burger meat type, size and price")
    class TestFirstMealSetBurgerMeatTypeSizeAndPrice {

        @Test
        public void testFirstMealSetBurgerMeatType() {
            assertEquals(BurgerMeatType.ROUND, firstMeal.getBurger().getMeatType());

            firstMeal.getBurger().setMeatType(BurgerMeatType.SIRLOIN);
            assertEquals(BurgerMeatType.SIRLOIN, firstMeal.getBurger().getMeatType());
        }

        @Test
        public void testFirstMealSetBurgerSize() {
            assertEquals(BurgerSize.MEDIUM, firstMeal.getBurger().getSize());

            firstMeal.getBurger().setSize(BurgerSize.LARGE);
            assertEquals(BurgerSize.LARGE, firstMeal.getBurger().getSize());
        }

        @Test
        public void testFirstMealSetBurgerPrice() {
            assertEquals(new BigDecimal("2.55"), firstMeal.getBurger().getPrice());

            firstMeal.getBurger().setPrice(new BigDecimal("2.75"));
            assertEquals(new BigDecimal("2.75"), firstMeal.getBurger().getPrice());
        }
    }

    @Nested
    @DisplayName("test first meal get and set drink")
    class TestFirstMealGetAndSetDrink {

        @Test
        public void testFirstMealGetDrink() {
            assertEquals(Drink.COKE_MEDIUM, firstMeal.getDrink());

            assertEquals("Coke", firstMeal.getDrink().getName());
            assertEquals("Medium", firstMeal.getDrink().getType());
            assertEquals(new BigDecimal("2.59"), firstMeal.getDrink().getPrice());
        }

        @Test
        public void testFirstMealSetDrink() {
            assertEquals(Drink.COKE_MEDIUM, firstMeal.getDrink());

            firstMeal.setDrink(Drink.PEPSI_LARGE);

            assertEquals(Drink.PEPSI_LARGE, firstMeal.getDrink());
            assertEquals("Pepsi", firstMeal.getDrink().getName());
            assertEquals("Large", firstMeal.getDrink().getType());
            assertEquals(new BigDecimal("3.09"), firstMeal.getDrink().getPrice());
        }
    }

    @Nested
    @DisplayName("test first meal get and set side")
    class TestFirstMealGetAndSetSide {

        @Test
        public void testFirstMealGetSide() {
            assertEquals(Side.FRIES_MEDIUM, firstMeal.getSide());

            assertEquals("Fries", firstMeal.getSide().getName());
            assertEquals("Medium", firstMeal.getSide().getType());
            assertEquals(new BigDecimal("1.99"), firstMeal.getSide().getPrice());
        }

        @Test
        public void testFirstMealSetSide() {
            assertEquals(Side.FRIES_MEDIUM, firstMeal.getSide());

            firstMeal.setSide(Side.ONION_RINGS_LARGE);

            assertEquals("Onion Rings", firstMeal.getSide().getName());
            assertEquals("Large", firstMeal.getSide().getType());
            assertEquals(new BigDecimal("2.49"), firstMeal.getSide().getPrice());
        }
    }

    @Nested
    @DisplayName("test get and set conversion rate")
    class TestGetAndSetConversionRate {

        @Test
        public void testFirstMealGetConversionRate() {
            assertEquals(new BigDecimal("1.00"), firstMeal.getConversionRate());
        }

        @Test
        public void testFirstMealSetConversionRate() {
            assertEquals(new BigDecimal("1.00"), firstMeal.getConversionRate());

            firstMeal.setConversionRate(new BigDecimal("1.67"));
            assertEquals(new BigDecimal("1.67"), firstMeal.getConversionRate());
        }
    }


}
