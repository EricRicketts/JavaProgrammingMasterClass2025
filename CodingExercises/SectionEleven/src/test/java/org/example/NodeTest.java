package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    private Node node;

    @BeforeEach
    public void setUp() {
        node = new Node(0);
    }

    @Nested
    @DisplayName("test get and set value")
    class TestGetAndSetNodeValues {

        @Test
        public void testGetValue() {
            assertEquals(0, node.getValue());
        }

        @Test
        public void testSetValue() {
            node.setValue(5);
            assertEquals(5, node.getValue());
        }
    }

    @Nested
    @DisplayName("test set and get next")
    class TestNodeSetAndGetNextNode {

        @Test
        public void testSetAndGetNextNode() {
            Node nextNode = new Node(10);
            Node expectedNextNode = new Node(10);
            node.setNext(nextNode);

            assertEquals(expectedNextNode, node.next());
        }
    }

    @Nested
    @DisplayName("test set and get previous")
    class TestNodeSetAndGetPreviousNode {

        @Test
        public void testSetAndGetPreviousNode() {
            Node previousNode = new Node(15);
            Node expectedPreviousNode = new Node(15);
            node.setPrevious(previousNode);

            assertEquals(expectedPreviousNode, node.previous());
        }
    }

    @Nested
    @DisplayName("test compareTo method")
    class TestCompareToMethod {

        @Test
        public void testCompareToReturnsOne() {
            Node firstNode = new Node(10);
            Node secondNode = new Node(9);

            assertEquals(1, firstNode.compareTo(secondNode));
        }

        @Test
        public void testCompareToReturnsNegativeOne() {
            Node firstNode = new Node(10);
            Node secondNode = new Node(11);

            assertEquals(-1, firstNode.compareTo(secondNode));
        }

        @Test
        public void testCompareToReturnsZero() {
            Node firstNode = new Node(10);
            Node secondNode = new Node(10);

            assertEquals(0, firstNode.compareTo(secondNode));
        }
    }
}
