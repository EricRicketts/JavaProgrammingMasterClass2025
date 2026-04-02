package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroceryItemTest {

    GroceryItem[] groceryList = new GroceryItem[3];
    /*
        Below, we instantiate an Array List of type GroceryItem.  This means all
        elements in the list must be a GroceryItem.  We preserve Java's type
        checking when we do this.  Note to complete the instantiation, we do
        not need to specify the type in the second <>.
     */
    ArrayList<GroceryItem> secondGroceryList = new ArrayList<>();
    ArrayList<GroceryItem> thirdGroceryList;

    @BeforeEach
    public void setUp() {
        groceryList[0] = new GroceryItem("milk");
        groceryList[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryList[2] = new GroceryItem("oranges", "PRODUCE", 5);
        secondGroceryList.add(new GroceryItem("butter"));
        secondGroceryList.add(new GroceryItem("pears", "PRODUCE", 3));
        thirdGroceryList = new ArrayList<>(
                List.of(new GroceryItem("milk"),
                new GroceryItem("apples", "PRODUCE", 6),
                new GroceryItem("oranges", "PRODUCE", 5),
                new GroceryItem("butter", "DAIRY", 3),
                new GroceryItem("spinach", "PRODUCE", 2),
                new GroceryItem("milk", "DAIRY", 3),
                new GroceryItem("cucumber", "PRODUCE", 4),
                new GroceryItem("pears", "PRODUCE", 5),
                new GroceryItem("milk", "DAIRY", 2),
                new GroceryItem("kale", "PRODUCE", 8))
        );
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

    @Test
    public void testAddAnItemToTheFrontOfAList() {
        secondGroceryList.addFirst(new GroceryItem("apples", "PRODUCE", 6));
        GroceryItem expected = new GroceryItem("apples", "PRODUCE", 6);
        GroceryItem result = secondGroceryList.getFirst();
        assertEquals(expected, result);
    }

    @Test
    public void testImmutableListFromMutableList() {
        String expected = "UnsupportedOperationException";
        // This creates an immutable list, we cannot add an element to an immutable list.
        List<GroceryItem> fourthGroceryList = List.copyOf(thirdGroceryList);
        UnsupportedOperationException thrown;
        thrown = assertThrows(
                UnsupportedOperationException.class,
                () -> {
                fourthGroceryList.add(new GroceryItem("carrots", "PRODUCE", 3));
                }, "Cannot add an element to an immutable list"
        );
        String illegalOperation = thrown.getClass().getSimpleName();
        assertEquals(expected, illegalOperation);
    }

    @Test
    public void testEffectOfAddingItemToFrontOfList() {
        // Once an item is added to the front of a list, everything shifts right by one slot.
        secondGroceryList.addFirst(new GroceryItem("apples", "PRODUCE", 6));
        GroceryItem expected = new GroceryItem("butter", "DAIRY", 1);
        GroceryItem result = secondGroceryList.get(1);
        assertEquals(expected, result);
    }

    @Test
    public void testAListToAList() {
        int[] expected = {2, 5};
        int originalListSize = secondGroceryList.size();
        List<GroceryItem> additionalItems = Arrays.asList(groceryList);
        secondGroceryList.addAll(additionalItems);
        int newListSize = secondGroceryList.size();
        int[] result = {originalListSize, newListSize};
        assertArrayEquals(expected, result);
        // The new list is added to the end of the list
        GroceryItem expectedLastItem = new GroceryItem("oranges", "PRODUCE", 5);
        GroceryItem resultantLastItem = secondGroceryList.getLast();
        assertEquals(expectedLastItem, resultantLastItem);
    }
}
