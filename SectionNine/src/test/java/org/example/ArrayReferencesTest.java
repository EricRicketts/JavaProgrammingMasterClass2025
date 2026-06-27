package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayReferencesTest {

    private int[] myIntArray = new int[5];
    private int[] anotherArray = myIntArray;

    @Nested
    @DisplayName("test array assignment")
    class TestArrayAssignment {

        @Test
        public void testMyIntArrayInitialization() {
            int[] expected = {0, 0, 0, 0, 0};
            assertArrayEquals(expected, myIntArray);
        }

        @Test
        public void testAnotherArrayInitialization() {
            int[] expected = {0, 0, 0, 0, 0};
            assertArrayEquals(expected, anotherArray);
        }

        @Test
        public void testChangeMyIntArrayChangesAnotherArray() {
            // This happens because both myIntArray and anotherArray point to the same location in memory.
            myIntArray[0] = 1;
            int[] expected = {1, 0, 0, 0, 0};

            assertArrayEquals(expected, myIntArray);
            assertArrayEquals(expected, anotherArray);
        }
    }
}
