package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Topping.CHEDDAR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTopping {


    @Test
    public void testTopping() {
        String[] expectedNames = {
            "BACON", "CHEDDAR", "KETCHUP", "MUSTARD", "PICKLES", "TOMATO"
        };

        double[] expectedPrices = {1.55, 0.55, 0.55, 0.55, 0.75, 0.75};

        for(int index = 0; index < expectedNames.length; index++) {
            String expectedName = expectedNames[index];
            double expectedPrice = expectedPrices[index];

            Topping currentTopping = Topping.values()[index];
            String currentName = currentTopping.name();
            double currentPrice = currentTopping.getPrice();

            assertEquals(expectedName, currentName);
            assertEquals(expectedPrice, currentPrice);
        }
    }

    @Test
    public void testConvertStringToEnumConstant() {
        assertEquals(CHEDDAR, Topping.valueOf("CHEDDAR"));
    }
}
