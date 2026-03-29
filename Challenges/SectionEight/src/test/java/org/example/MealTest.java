package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {

    Meal firstMeal, secondMeal, thirdMeal, fourthMeal;
    String expected, result;

    @BeforeEach
    public void setUp() {
        firstMeal = new Meal(
                new Burger("large", 13.00),
                new Drink("Coke", "large"),
                new SideItem("fries"));

        secondMeal = new Meal(
                new Burger("small", 13.00),
                new Drink("Pepsi", "small"),
                new SideItem("onion rings"),
                "lettuce");

        thirdMeal = new Meal(
                new Burger("medium", 13.00),
                new Drink("Mountain Dow", "medium"),
                new SideItem("salad"),
                "lettuce", "tomatoes");

        fourthMeal = new Meal(
                new Burger("large", 13.00),
                new Drink("Dr Pepper", "large"),
                new SideItem("fries"),
                "lettuce", "tomatoes", "cheese");

    }

    @Disabled
    @Test
    public void testFirstMeal() {
        expected =
            "Burger: type: large, price: 25.00\n" +
            "Drink: type: coke, price: 3.20\n" +
            "Side: type: fries, price: 2.50\n" +
            "Toppings:\n" + "Total Price: 30.7";
        result = firstMeal.getReceipt();
        assertEquals(expected, result);
    }

    @Test
    public void testSecondMeal() {
        expected =
            "Burger: type: small, price: 6.00\n" +
            "Drink: type: pepsi, price: 1.20\n" +
            "Side: type: onion rings, price: 3.00\n" +
            "Toppings: lettuce: 1.00\n" + "Total Price: 13.2";
        result = secondMeal.getReceipt();
        assertEquals(expected, result);
    }

    @Disabled
    @Test
    public void testThirdMeal() {
        expected =
                "Burger: type: small, price: 6.00\n" +
                        "Drink: type: pepsi, price: 1.20\n" +
                        "Side: type: onion rings, price: 3.00\n" +
                        "Toppings: lettuce: 1.00\n";
        result = thirdMeal.getReceipt();
        assertEquals(expected, result);
    }

    @Disabled
    @Test
    public void testFourthMeal() {
        expected =
                "Burger: type: small, price: 6.00\n" +
                        "Drink: type: pepsi, price: 1.20\n" +
                        "Side: type: onion rings, price: 3.00\n" +
                        "Toppings: lettuce: 1.00\n";
        result = fourthMeal.getReceipt();
        assertEquals(expected, result);
    }
}
