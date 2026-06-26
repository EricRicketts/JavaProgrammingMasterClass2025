package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    Object[] expected, result;
    Drink smallDrink, mediumDrink, largeDrink,
        otherDrink, firstDrink, secondDrink;

    @BeforeEach
    public void setUp() {
        smallDrink = new Drink("Coke", "Small");
        mediumDrink = new Drink("Pepsi", "Medium");
        largeDrink = new Drink("Mountain Dew", "Large");
        otherDrink = new Drink("Dr Pepper", "Regular");
    }

    @Nested
    @DisplayName("test drink sizes")
    class TestDrinkSizes {

        @Test
        public void testSmallDrink() {
            expected = new Object[]{"coke", "small", new BigDecimal("1.20")};
            result = new Object[]{
                smallDrink.getType(), smallDrink.getSize(), smallDrink.getPrice()
            };
            assertArrayEquals(expected, result);
        }

        @Test
        public void testMediumDrink() {
            expected = new Object[]{"pepsi", "medium", new BigDecimal("2.60")};
            result = new Object[]{
                mediumDrink.getType(), mediumDrink.getSize(), mediumDrink.getPrice()
            };
            assertArrayEquals(expected, result);
        }

        @Test
        public void testLargeDrink() {
            expected = new Object[]{"mountain dew", "large", new BigDecimal("3.20")};
            result = new Object[]{
                largeDrink.getType(), largeDrink.getSize(), largeDrink.getPrice()
            };
            assertArrayEquals(expected, result);
        }

        @Test
        public void testOtherDrink() {
            expected = new Object[]{"dr pepper", "regular", new BigDecimal("2.20")};
            result = new Object[]{
                otherDrink.getType(), otherDrink.getSize(), otherDrink.getPrice()
            };
            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test drink getters")
    class TestDrinkGetters {

        @Test
        public void testGetDrinkType() {
            assertEquals("coke", smallDrink.getType());
        }

        @Test
        public void testGetDrinkSize() {
            assertEquals("medium", mediumDrink.getSize());
        }

        @Test
        public void testGetDrinkPrice() {
            assertEquals(new BigDecimal("2.20"), otherDrink.getPrice());
        }
    }

    @Nested
    @DisplayName("test drink setters")
    class TestDrinkSetters {

        @Test
        public void testSetDrinkSize() {
            assertEquals("large", largeDrink.getSize());

            largeDrink.setSize("Extra Large");

            assertEquals("extra large", largeDrink.getSize());
        }
    }

    @Nested
    @DisplayName("test drink equality")
    class TestDrinkEquality {

        @Test
        public void testTwoEqualDrinks() {
            firstDrink = new Drink("COKE", "LARGE");
            secondDrink = new Drink("coke", "large");

            assertEquals(firstDrink, secondDrink);
        }

        @Test
        public void testTwoNonEqualDrinksDifferentSizes() {
            firstDrink = new Drink("coke", "medium");
            secondDrink = new Drink("coke", "large");

            assertNotEquals(firstDrink, secondDrink);
        }

        @Test
        public void testTwoNonEqualDrinksDifferentTypes() {
            firstDrink = new Drink("pepsi", "large");
            secondDrink = new Drink("coke", "large");

            assertNotEquals(firstDrink, secondDrink);
        }
    }
}
