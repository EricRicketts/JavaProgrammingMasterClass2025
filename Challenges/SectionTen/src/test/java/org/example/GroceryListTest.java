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

    @Test
    public void testAddOneItem() {
        expected = "apples\ncucumbers\nkale\nlettuce\noranges\ntomatoes";
        groceryList.addItems("kale");
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testAddMoreThanOneItem() {
        expected = "apples\ncabbage\ncucumbers\nkale\nlettuce\noranges\nrice\nspinach\ntomatoes";
        String itemsToAdd = "kale,  spinach, cabbage,rice";
        groceryList.addItems(itemsToAdd);
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testDuplicatesNotAdded() {
        expected = "apples\ncucumbers\nkale\nlettuce\noranges\nrice\ntomatoes";
        String itemsToAdd = "kale, rice, kale";
        groceryList.addItems(itemsToAdd);
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveOneItem() {
        expected = "apples\ncucumbers\noranges\ntomatoes";
        groceryList.removeItems("lettuce");
        result = groceryList.printList();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveMoreThanOneItem() {
        expected = "cucumbers\nlettuce";
        String itemsToAdd = "oranges,  tomatoes,apples";
        groceryList.removeItems(itemsToAdd);
        result = groceryList.printList();
        assertEquals(expected, result);
    }
}
