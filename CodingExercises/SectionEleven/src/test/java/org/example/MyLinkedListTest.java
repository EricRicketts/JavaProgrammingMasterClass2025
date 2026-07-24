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
        assertNull(list.addItem(new Node("Darwin")));
        assertNull(list.addItem(new Node("Brisbane")));
        assertNull(list.addItem(new Node("Perth")));
        assertEquals("Darwin is already present, not added.", list.addItem(new Node("Darwin"))); // Duplicate

        assertEquals("Brisbane", list.getRoot().getValue());
        assertEquals("Darwin", list.getRoot().next().getValue());
        assertEquals("Perth", list.getRoot().next().next().getValue());
    }

    @Test
    public void testRemoveItem() {
        list.addItem(new Node("Darwin"));
        list.addItem(new Node("Brisbane"));
        list.addItem(new Node("Perth"));

        assertEquals("Deleting item Darwin", list.removeItem(new Node("Darwin")));
        assertEquals("Brisbane", list.getRoot().getValue());
        assertEquals("Perth", list.getRoot().next().getValue());

        assertEquals("Deleting item Brisbane", list.removeItem(new Node("Brisbane")));
        assertEquals("Perth", list.getRoot().getValue());

        assertEquals("Deleting item Perth", list.removeItem(new Node("Perth")));
        assertNull(list.getRoot());

        assertNull(list.removeItem(new Node("NonExistent")));
    }

    @Test
    public void testTraverse() {
        assertEquals("The list is empty", list.traverse(list.getRoot()));

        list.addItem(new Node("Darwin"));
        list.addItem(new Node("Brisbane"));
        list.addItem(new Node("Perth"));

        String expected = "Brisbane" + "\n" +
                          "Darwin" + "\n" +
                          "Perth";
        assertEquals(expected, list.traverse(list.getRoot()));
    }
}
