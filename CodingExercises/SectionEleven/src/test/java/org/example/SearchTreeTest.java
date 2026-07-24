package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTreeTest {

    private SearchTree tree;

    @BeforeEach
    public void setUp() {
        tree = new SearchTree(null);
    }

    @Test
    public void testAddItem() {
        assertNull(tree.addItem(new Node("Darwin")));
        assertNull(tree.addItem(new Node("Brisbane")));
        assertNull(tree.addItem(new Node("Perth")));
        assertEquals("Darwin is already present", tree.addItem(new Node("Darwin"))); // Duplicate

        assertEquals("Darwin", tree.getRoot().getValue());
        assertEquals("Brisbane", tree.getRoot().previous().getValue());
        assertEquals("Perth", tree.getRoot().next().getValue());
    }

    @Test
    public void testRemoveItem() {
        tree.addItem(new Node("5"));
        tree.addItem(new Node("3"));
        tree.addItem(new Node("7"));
        tree.addItem(new Node("2"));
        tree.addItem(new Node("4"));
        tree.addItem(new Node("6"));
        tree.addItem(new Node("8"));

        // Remove leaf
        assertEquals("Deleting item 2", tree.removeItem(new Node("2")));
        assertNull(tree.getRoot().previous().previous());

        // Remove node with one child
        assertEquals("Deleting item 3", tree.removeItem(new Node("3")));
        assertEquals("4", tree.getRoot().previous().getValue());

        // Remove node with two children (root)
        assertEquals("Deleting item 5", tree.removeItem(new Node("5")));
        assertEquals("6", tree.getRoot().getValue());
        assertEquals("4", tree.getRoot().previous().getValue());
        assertEquals("7", tree.getRoot().next().getValue());

        assertNull(tree.removeItem(new Node("NonExistent")));
    }

    @Test
    public void testTraverse() {
        assertEquals("", tree.traverse(tree.getRoot()));

        tree.addItem(new Node("Darwin"));
        tree.addItem(new Node("Brisbane"));
        tree.addItem(new Node("Perth"));
        tree.addItem(new Node("Adelaide"));

        String expected = "Adelaide" + "\n" +
                          "Brisbane" + "\n" +
                          "Darwin" + "\n" +
                          "Perth";
        assertEquals(expected, tree.traverse(tree.getRoot()));
    }
}
