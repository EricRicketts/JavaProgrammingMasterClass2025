package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
            smartKitchen.getCoffeeMaker().brewCoffee(),
            smartKitchen.getDishWasher().doDishes(),
            smartKitchen.getRefrigerator().orderFood()
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
                smartKitchen.getCoffeeMaker().brewCoffee(),
                smartKitchen.getDishWasher().doDishes(),
                smartKitchen.getRefrigerator().orderFood()
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

    @Test
    public void testSetCoffeeMaker() {
        CoffeeMaker originalCoffeeMaker = smartKitchen.getCoffeeMaker();

        smartKitchen.setCoffeeMaker(new CoffeeMaker(false));
        CoffeeMaker newCoffeeMaker = smartKitchen.getCoffeeMaker();

        assertNotSame(originalCoffeeMaker, newCoffeeMaker);
    }

    @Test
    public void testSetDishwasher() {
        DishWasher originalDishwasher = smartKitchen.getDishWasher();

        smartKitchen.setDishWasher(new DishWasher(false));
        DishWasher newDishWasher = smartKitchen.getDishWasher();

        assertNotSame(originalDishwasher, newDishWasher);
    }

    @Test
    public void testSetRefrigerator() {
        Refrigerator originalRefrigerator = smartKitchen.getRefrigerator();

        smartKitchen.setRefrigerator(new Refrigerator(false));
        Refrigerator newRefrigerator = smartKitchen.getRefrigerator();

        assertNotSame(originalRefrigerator, newRefrigerator);
    }
}
