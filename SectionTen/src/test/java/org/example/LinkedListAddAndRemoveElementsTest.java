package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListAddAndRemoveElementsTest {

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin"); // Add to the first position of the list.
        list.addLast("Hobart");  // Add to the last position of the list.
        // Queue methods
        list.offer("Melbourne"); // Offer means to add to the rear of the list.
        list.offerFirst("Brisbane"); // Another way of saying insert at the beginning of the list.
        list.offerLast("Toowoomba"); // Another way of saying insert at the end of the list.
        // Stack methods
        list.push("Alice Springs"); // Stack language for adding to the beginning of the list.
    }
    LinkedList<String> placesToVisit;
    String expected, result;

    @BeforeEach
    public void setUp() {
        placesToVisit = new LinkedList<>();
    }

    @Test
    public void testOtherWaysToDeclareLinkedLists() {
        String expected = "LinkedList";
        String result = LinkedList.class.getSimpleName();
        assertEquals(expected, result);
    }

    @Test
    public void testAddItemsUsingArrayListMethods() {
        String expected = "[Alice Springs, Brisbane, Darwin, London, Paris, Berlin," +
                " Hobart, Melbourne, Toowoomba]";
        // Adding to a list adds to the back of the list unless specified otherwise
        placesToVisit.add("Paris");
        placesToVisit.addFirst("London");
        placesToVisit.add("Berlin");
        addMoreElements(placesToVisit);
        String result = placesToVisit.toString();
        assertEquals(expected, result);

        // Removing elements from a LinkedList.
        placesToVisit.remove(4);
        placesToVisit.remove("Brisbane");
        expected = "[Alice Springs, Darwin, London, Berlin, Hobart, Melbourne, Toowoomba]";
        result = placesToVisit.toString();
        assertEquals(expected, result);
    }
}
