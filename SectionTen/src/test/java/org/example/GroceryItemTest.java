package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GroceryItemTest {

    GroceryItem[] groceryList = new GroceryItem[3];

    @BeforeEach
    public void setUp() {
        groceryList[0] = new GroceryItem("milk");
        groceryList[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryList[2] = new GroceryItem("oranges", "PRODUCE", 5);
    }

    @Test
    public void testGettingEachElementOfTheFirstRecord() {
        Object[] expected = {"milk", "DAIRY", 1};
        Object[] result = {
                groceryList[0].name(),
                groceryList[0].type(),
                groceryList[0].count()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGettingEachElementOfTheThirdRecord() {
        Object[] expected = {"oranges", "PRODUCE", 5};
        Object[] result = {
                groceryList[2].name(),
                groceryList[2].type(),
                groceryList[2].count()
        };
        assertArrayEquals(expected, result);
    }
}
