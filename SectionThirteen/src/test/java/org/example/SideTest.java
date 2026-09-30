package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideTest {

    private Side side;

    @Nested
    @DisplayName("test fries side")
    class TestFriesSide {

        @Test
        public void testSmallFries() {
            side = Side.FRIES_SMALL;

            assertEquals("Fries", side.getName());
            assertEquals("Small", side.getType());
            assertEquals(new BigDecimal("1.59"), side.getPrice());
        }

        @Test
        public void testMediumFries() {
            side = Side.FRIES_MEDIUM;

            assertEquals("Fries", side.getName());
            assertEquals("Medium", side.getType());
            assertEquals(new BigDecimal("1.99"), side.getPrice());
        }

        @Test
        public void testLargeFries() {
            side = Side.FRIES_LARGE;

            assertEquals("Fries", side.getName());
            assertEquals("Large", side.getType());
            assertEquals(new BigDecimal("2.29"), side.getPrice());
        }
    }
}
