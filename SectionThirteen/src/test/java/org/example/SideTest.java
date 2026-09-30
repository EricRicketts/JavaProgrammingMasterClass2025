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

    @Nested
    @DisplayName("test onion rings side")
    class TestOnionRingsSide {

        @Test
        public void testSmallOnionRings() {
            side = Side.ONION_RINGS_SMALL;

            assertEquals("Onion Rings", side.getName());
            assertEquals("Small", side.getType());
            assertEquals(new BigDecimal("1.79"), side.getPrice());
        }

        @Test
        public void testMediumOnionRings() {
            side = Side.ONION_RINGS_MEDIUM;

            assertEquals("Onion Rings", side.getName());
            assertEquals("Medium", side.getType());
            assertEquals(new BigDecimal("2.19"), side.getPrice());
        }

        @Test
        public void testLargeOnionRings() {
            side = Side.ONION_RINGS_LARGE;

            assertEquals("Onion Rings", side.getName());
            assertEquals("Large", side.getType());
            assertEquals(new BigDecimal("2.49"), side.getPrice());
        }
    }

    @Nested
    @DisplayName("test side salad")
    class TestSideSalad {

        @Test
        public void testSmallSideSalad() {
            side = Side.SIDE_SALAD_SMALL;

            assertEquals("Side Salad", side.getName());
            assertEquals("Small", side.getType());
            assertEquals(new BigDecimal("2.59"), side.getPrice());
        }

        @Test
        public void testMediumSideSalad() {
            side = Side.SIDE_SALAD_MEDIUM;

            assertEquals("Side Salad", side.getName());
            assertEquals("Medium", side.getType());
            assertEquals(new BigDecimal("2.99"), side.getPrice());
        }

        @Test
        public void testLargeSideSalad() {
            side = Side.SIDE_SALAD_LARGE;

            assertEquals("Side Salad", side.getName());
            assertEquals("Large", side.getType());
            assertEquals(new BigDecimal("3.29"), side.getPrice());
        }
    }

    @Nested
    @DisplayName("test side toString()")
    class TestSideToString {

        @Test
        public void testSideToString() {
            side = Side.ONION_RINGS_LARGE;
            String expected = """
                Side: Onion Rings
                Type: Large
                Price: $2.49
                """;
            String result = side.toString();

            assertEquals(expected, result);
        }
    }
}
