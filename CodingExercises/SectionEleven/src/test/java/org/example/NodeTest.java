package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    private Node node;

    @BeforeEach
    public void setUp() {
        node = new Node("A");
    }

    @Test
    public void testGetValue() {
        assertEquals("A", node.getValue());
    }

    @Test
    public void testSetValue() {
        node.setValue("B");
        assertEquals("B", node.getValue());
    }

    @Test
    public void testSetAndGetNextNode() {
        Node nextNode = new Node("C");
        node.setNext(nextNode);
        assertEquals(nextNode, node.next());
    }

    @Test
    public void testSetAndGetPreviousNode() {
        Node previousNode = new Node("D");
        node.setPrevious(previousNode);
        assertEquals(previousNode, node.previous());
    }

    @Test
    public void testCompareTo() {
        Node node1 = new Node("Apple");
        Node node2 = new Node("Banana");
        Node node3 = new Node("Apple");

        assertTrue(node1.compareTo(node2) < 0);
        assertTrue(node2.compareTo(node1) > 0);
        assertEquals(0, node1.compareTo(node3));
    }
}
