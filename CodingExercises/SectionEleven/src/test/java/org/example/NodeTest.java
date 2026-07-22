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
}
