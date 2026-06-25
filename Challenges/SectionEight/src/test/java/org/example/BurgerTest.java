package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {

    Burger smallBurger, mediumBurger, largeBurger, burger;
    String[] expectedTypes, resultantTypes;
    BigDecimal[] expectedPrices, resultantPrices;

    @BeforeEach
    public void setUp() {
        smallBurger = new Burger("small", new BigDecimal("15.00"));
        mediumBurger = new Burger("medium", new BigDecimal("15.00"));
        largeBurger = new Burger("large", new BigDecimal("15.00"));
        burger = new Burger("regular", new BigDecimal("13.00"));
    }

    @Test
    public void testAllBurgers() {
        expectedTypes = new String[]{"small", "medium", "large", "regular"};
        expectedPrices = new BigDecimal[]{
            new BigDecimal("6.00"),
            new BigDecimal("15.00"),
            new BigDecimal("25.00"),
            new BigDecimal("12.00")
        };
        for (int i = 0; i < expectedTypes.length; i++) {
            BigDecimal priceSlot = new BigDecimal("12.00");
            String type = expectedTypes[i];
            Burger burger = new Burger(type, priceSlot);
            BigDecimal expectedPrice = new BigDecimal(String.valueOf(expectedPrices[i]));
            assertEquals(type, burger.getType());
            assertEquals(expectedPrice, burger.getPrice());
        }
    }

    @Test
    public void testSetToppingOnABurger() {
        String[] toppingTypes = new String[]{"lettuce", "tomatoes", "cheese"};
        BigDecimal[] expectedPrices = new BigDecimal[]{
            new BigDecimal("1.00"),
            new BigDecimal("1.50"),
            new BigDecimal("2.00")
        };
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
