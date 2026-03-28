package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DrinkTest {

    Object[] expected, result;
    Drink smallDrink, mediumDrink, largeDrink, otherDrink;

    @BeforeEach
    public void setUp() {
        smallDrink = new Drink("Coke", "Small");
        mediumDrink = new Drink("Pepsi", "Medium");
        largeDrink = new Drink("Mountain Dew", "Large");
        otherDrink = new Drink("Dr Pepper", "Regular");
    }

    @Test
    public void testSmallDrink() {
        expected = new Object[]{"Coke", "small", 1.20};
        result = new Object[]{
                smallDrink.getType(), smallDrink.getSize(), smallDrink.getPrice()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMediumDrink() {
        expected = new Object[]{"Pepsi", "medium", 2.60};
        result = new Object[]{
                mediumDrink.getType(), mediumDrink.getSize(), mediumDrink.getPrice()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testLargeDrink() {
        expected = new Object[]{"Mountain Dew", "large", 3.20};
        result = new Object[]{
                largeDrink.getType(), largeDrink.getSize(), largeDrink.getPrice()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOtherDrink() {
        expected = new Object[]{"Dr Pepper", "regular", 2.20};
        result = new Object[]{
                otherDrink.getType(), otherDrink.getSize(), otherDrink.getPrice()
        };
        assertArrayEquals(expected, result);
    }
}
