package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroceryListTest {

    String expected, result;

    private GroceryList groceryList;

    @BeforeEach
    public void setUp() {
        String[] items = {"apples", "oranges", "lettuce", "tomatoes", "cucumbers"};
        groceryList = new GroceryList();
        for (String item : items) {
            groceryList.addItems(item);
        }
    }

    @Disabled
    @Test
    public void testGroceryListWasInitialized() {
    }

    @Disabled
    @Test
    public void testAddOneItem() {
        expected = "apples\noranges\nlettuce\ntomatoes\ncucumbers\nkale";
        groceryList.addItems("kale");
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Disabled
    @Test
    public void testAddMoreThanOneItem() {
        expected = "apples\noranges\nlettuce\ntomatoes\ncucumbers\nkale\nspinach\ncabbage\nrice";
        String itemsToAdd = "kale,  spinach, cabbage,rice";
        groceryList.addItems(itemsToAdd);
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveOneItem() {
        expected = "apples\noranges\ntomatoes\ncucumbers";
        groceryList.removeItems("lettuce");
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveMoreThanOneItem() {
        expected = "lettuce\ncucumbers";
        String itemsToAdd = "oranges,  tomatoes,apples";
        groceryList.removeItems(itemsToAdd);
        result = groceryList.printList();
        assertEquals(expected, result);
    }
}
