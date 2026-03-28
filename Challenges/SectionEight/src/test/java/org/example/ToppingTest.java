package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToppingTest {

    Topping topping;

    @Test
    public void testToppingTypesAndPrice() {
        double[] expectedPrices = new double[]{
                1.00, 1.50, 2.00, 0.50
        };

        String[] toppings = new String[]{
                "lettuce", "tomatoes", "cheese", "onion"
        };
        for (int i = 0; i < toppings.length; i++) {
            Topping topping = new Topping(toppings[i]);
            double result = topping.getPrice();
            double expectedPrice = expectedPrices[i];
            assertEquals(expectedPrice, result);
            assertEquals(toppings[i], topping.getType());
        }
    }
}
