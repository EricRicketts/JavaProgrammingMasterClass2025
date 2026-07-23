package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    private MyLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new MyLinkedList(null);
    }

    @Test
    public void testAddItem() {
        assertTrue(list.addItem(new Node(10)));
        assertTrue(list.addItem(new Node(5)));
        assertTrue(list.addItem(new Node(15)));
        assertFalse(list.addItem(new Node(10))); // Duplicate

        assertEquals(5, list.getRoot().getValue());
        assertEquals(10, list.getRoot().next().getValue());
        assertEquals(15, list.getRoot().next().next().getValue());
    }

    @Test
    public void testRemoveItem() {
        list.addItem(new Node(10));
        list.addItem(new Node(5));
        list.addItem(new Node(15));

        assertTrue(list.removeItem(new Node(10)));
        assertEquals(5, list.getRoot().getValue());
        assertEquals(15, list.getRoot().next().getValue());

        assertTrue(list.removeItem(new Node(5)));
        assertEquals(15, list.getRoot().getValue());

        assertTrue(list.removeItem(new Node(15)));
        assertNull(list.getRoot());
    }

    @Test
    public void testTraverse() {
        assertEquals("The list is empty", list.traverse());

        list.addItem(new Node(10));
        list.addItem(new Node(5));
        list.addItem(new Node(15));

        assertEquals("5 10 15", list.traverse());
    }
}
