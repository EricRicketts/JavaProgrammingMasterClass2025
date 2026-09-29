package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkTest {

    private Drink drink;

    @BeforeEach
    public void setUp() {
        drink = Drink.MOUNTAIN_DEW_MEDIUM;
    }

    @Nested
    @DisplayName("test enum drink getters")
    class TestDrinkGetters {

        @Test
        public void testDrinkNameGetter() {
            assertEquals("Mountain Dew", drink.getName());
        }

        @Test
        public void testDrinkTypeGetter() {
            assertEquals("Medium", drink.getType());
        }

        @Test
        public void testDrinkPriceGetter() {
            assertEquals(new BigDecimal("2.59"), drink.getPrice());
        }
    }
}
