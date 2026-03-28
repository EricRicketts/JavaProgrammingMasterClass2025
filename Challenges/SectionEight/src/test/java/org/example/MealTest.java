package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MealTest {

    Meal firstMeal, secondMeal, thirdMeal, fourthMeal;

    @BeforeEach
    public void setUp() {
        firstMeal = new Meal(
                new Burger("large", 13.00),
                new Drink("Coke", "large"),
                new SideItem("fries"));
    }

    @Test
    public void testFirstMeal() {
        int x = 1;
        String receipt = firstMeal.getReceipt();
        int y = 2;
    }
}
