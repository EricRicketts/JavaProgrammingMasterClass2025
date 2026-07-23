package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTreeTest {

    private SearchTree tree;

    @BeforeEach
    public void setUp() {
        tree = new SearchTree(new Node(0));
    }

    @Nested
    @DisplayName("test get root")
    class TestGetRoot {

        @Test
        public void testGetRootOfSearchTree() {
            Node expectedValue = new Node(0);
            assertEquals(expectedValue, tree.getRoot());
        }
    }
}
