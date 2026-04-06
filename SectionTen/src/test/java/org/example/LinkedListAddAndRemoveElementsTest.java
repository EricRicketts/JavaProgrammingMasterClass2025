package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListAddAndRemoveElementsTest {

    LinkedList<String> placesToVisit;
    String expected, result;

    @BeforeEach
    public void setUp() {
        placesToVisit = new LinkedList<String>();
    }

    @Test
    public void testOtherWaysToDeclareLinkedLists() {
        String expected = "LinkedList";
        String result = LinkedList.class.getSimpleName();
        assertEquals(expected, result);
    }

    @Test
    public void testAddItemsUsingArrayListMethods() {
        placesToVisit.add("Paris");
        placesToVisit.add("London");
        placesToVisit.add("Berlin");

    }
}
