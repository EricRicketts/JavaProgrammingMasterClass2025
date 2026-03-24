package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartKitchenTest {

    SmartKitchen smartKitchen;
    String[] expected, results;

    @BeforeEach
    public void setUp() {
        CoffeeMaker coffeeMaker = new CoffeeMaker(false);
        DishWasher dishWasher = new DishWasher(false);
        Refrigerator refrigerator = new Refrigerator(false);
        smartKitchen = new SmartKitchen(coffeeMaker, dishWasher, refrigerator);
    }

    @Test
    public void testInitialStateOfAllKitchenAppliances() {
        expected = new String[]{
                "No coffee is brewing.",
                "The dishwasher is off.",
                "No food has been ordered."
        };
        results = new String[]{
            smartKitchen.getBrewMaster().brewCoffee(),
            smartKitchen.getDishWasher().doDishes(),
            smartKitchen.getIceBox().orderFood()
        };

        assertArrayEquals(expected, results);
    }

    @Test
    public void testChangeStateOfAllAppliances() {
        expected = new String[]{
                "Coffee is brewing.",
                "The dishwasher is on.",
                "Food has been ordered."
        };
        smartKitchen.setKitchenState(true, true, true);
        results = new String[]{
                smartKitchen.getBrewMaster().brewCoffee(),
                smartKitchen.getDishWasher().doDishes(),
                smartKitchen.getIceBox().orderFood()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testDoKitchenWorkMethod() {
        smartKitchen.setKitchenState(false, true, false);
        String expected = "No coffee is brewing." + " " + "The dishwasher is on." + " " +
                "No food has been ordered.";
        String result = smartKitchen.doKitchenWork();
        assertEquals(expected, result);
    }
}
