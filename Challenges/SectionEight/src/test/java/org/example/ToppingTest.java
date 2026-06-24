package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {

    Topping topping;

    @Test
    public void testToppingTypesAndPrice() {
        BigDecimal[] expectedPrices = new BigDecimal[]{
                new BigDecimal("1.00"),
                new BigDecimal("1.50"),
                new BigDecimal("2.00"),
                new BigDecimal("0.50")
        };

        String[] toppings = new String[]{
                "lettuce", "tomatoes", "cheese", "onion"
        };
        for (int i = 0; i < toppings.length; i++) {
            Topping topping = new Topping(toppings[i]);
            BigDecimal result = topping.getPrice();
            BigDecimal expectedPrice = expectedPrices[i];
            assertEquals(expectedPrice, result);
            assertEquals(toppings[i], topping.getType());
        }
    }
}
