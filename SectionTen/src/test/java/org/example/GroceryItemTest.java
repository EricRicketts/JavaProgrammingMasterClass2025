package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GroceryItemTest {

    GroceryItem[] groceryList = new GroceryItem[3];
    /*
        Below, we instantiate an Array List of type GroceryItem.  This means all
        elements in the list must be a GroceryItem.  We preserve Java's type
        checking when we do this.  Note to complete the instantiation, we do
        not need to specify the type in the second <>.
     */
    ArrayList<GroceryItem> secondGroceryList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        groceryList[0] = new GroceryItem("milk");
        groceryList[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryList[2] = new GroceryItem("oranges", "PRODUCE", 5);
        secondGroceryList.add(new GroceryItem("butter"));
        secondGroceryList.add(new GroceryItem("pears", "PRODUCE", 3));
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
