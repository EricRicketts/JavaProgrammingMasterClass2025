package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnaryOperatorTest {

    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(
            List.of(
                "alpha", "bravo", "charlie", "delta",
                "echo", "foxtrot", "golf", "hotel"
            )
        );
    }

    @Nested
    @DisplayName("Test Unary Operations")
    class TestUnaryOperations {

        @Test
        public void testReplaceAll() {
            List<String> expected = new ArrayList<>(
                List.of(
                "a - ALPHA", "b - BRAVO", "c - CHARLIE", "d - DELTA",
                "e - ECHO", "f - FOXTROT", "g - GOLF", "h - HOTEL"
                )
            );
            list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());

            assertEquals(expected, list);
        }
    }

}
