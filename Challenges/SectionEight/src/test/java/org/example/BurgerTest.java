package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {

    Burger smallBurger, mediumBurger, largeBurger, burger;
    String[] expectedTypes, resultantTypes;
    double[] expectedPrices, resultantPrices;

    @BeforeEach
    public void setUp() {
        smallBurger = new Burger("small", 15.00);
        mediumBurger = new Burger("medium", 15.00);
        largeBurger = new Burger("large", 15.00);
        burger = new Burger("regular", 13.00);
    }

    @Test
    public void testAllBurgers() {
        expectedTypes = new String[]{"small", "medium", "large", "regular"};
        expectedPrices = new double[]{6.00, 15.00, 25.00, 12.00};
        for (int i = 0; i < expectedTypes.length; i++) {
            double priceSlot = 12.00;
            String type = expectedTypes[i];
            Burger burger = new Burger(type, priceSlot);
            double expectedPrice = expectedPrices[i];
            assertEquals(type, burger.getType());
            assertEquals(expectedPrice, burger.getPrice());
        }
    }

    @Test
    public void testSetToppingOnABurger() {
        String[] toppingTypes = new String[]{"lettuce", "tomatoes", "cheese"};
        double[] expectedPrices = new double[]{1.00, 1.50, 2.00};
        for (int i = 0; i < 3; i++) {
            largeBurger.addTopping(toppingTypes[i]);
        }
        for (int i = 0; i < 3; i++) {
            Topping topping = largeBurger.getToppings()[i];
            assertEquals(toppingTypes[i], topping.getType());
            assertEquals(expectedPrices[i], topping.getPrice());
        }
    }

}
