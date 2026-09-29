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

    @Nested
    @DisplayName("test Coke constants")
    class TestCokeConstants {

        @Test
        public void testCokeSmall() {
            drink = Drink.COKE_SMALL;
            assertEquals("Coke", drink.getName());
            assertEquals("Small", drink.getType());
            assertEquals(new BigDecimal("1.19"), drink.getPrice());
        }

        @Test
        public void testCokeMedium() {
            drink = Drink.COKE_MEDIUM;
            assertEquals("Coke", drink.getName());
            assertEquals("Medium", drink.getType());
            assertEquals(new BigDecimal("2.59"), drink.getPrice());
        }

        @Test
        public void testCokeLarge() {
            drink = Drink.COKE_LARGE;
            assertEquals("Coke", drink.getName());
            assertEquals("Large", drink.getType());
            assertEquals(new BigDecimal("3.19"), drink.getPrice());
        }

        @Test
        public void testCokeExtraLarge() {
            drink = Drink.COKE_EXTRA_LARGE;
            assertEquals("Coke", drink.getName());
            assertEquals("Extra_Large", drink.getType());
            assertEquals(new BigDecimal("3.99"), drink.getPrice());
        }
    }

    @Nested
    @DisplayName("test Pepsi constants")
    class TestPepsiConstants {

        @Test
        public void testPepsiSmall() {
            drink = Drink.PEPSI_SMALL;
            assertEquals("Pepsi", drink.getName());
            assertEquals("Small", drink.getType());
            assertEquals(new BigDecimal("1.09"), drink.getPrice());
        }

        @Test
        public void testPepsiMedium() {
            drink = Drink.PEPSI_MEDIUM;
            assertEquals("Pepsi", drink.getName());
            assertEquals("Medium", drink.getType());
            assertEquals(new BigDecimal("2.49"), drink.getPrice());
        }

        @Test
        public void testPepsiLarge() {
            drink = Drink.PEPSI_LARGE;
            assertEquals("Pepsi", drink.getName());
            assertEquals("Large", drink.getType());
            assertEquals(new BigDecimal("3.09"), drink.getPrice());
        }

        @Test
        public void testPepsiExtraLarge() {
            drink = Drink.PEPSI_EXTRA_LARGE;
            assertEquals("Pepsi", drink.getName());
            assertEquals("Extra_Large", drink.getType());
            assertEquals(new BigDecimal("3.89"), drink.getPrice());
        }
    }
}
