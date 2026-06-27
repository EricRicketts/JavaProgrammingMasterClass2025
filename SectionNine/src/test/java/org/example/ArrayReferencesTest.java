package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayReferencesTest {

    private int[] myIntArray = new int[5];
    private int[] anotherArray = myIntArray;

    @Nested
    @DisplayName("test array assignment")
    class TestArrayAssignment {

        private static void modifyArray(int[] array) {
            array[1] = 2;
        }

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
            // Thus, when I change the value of a location in myIntArray, which changes the value in memory,
            // this update affects both variables, which point to this same location in memory.
            myIntArray[0] = 1;
            int[] expected = {1, 0, 0, 0, 0};

            assertArrayEquals(expected, myIntArray);
            assertArrayEquals(expected, anotherArray);
        }

        @Test
        public void testCopyMyIntArrayDoesNotChangeMyIntArray() {
            // Copying creates a new array with a different memory address, so when I change the value of one location
            // in myIntArray, this does not affect copiedArray, as its memory location is completely different.
            int[] copiedArray = Arrays.copyOf(myIntArray, myIntArray.length);
            myIntArray[0] = 1;
            int[] expectedMyIntArray = {1, 0, 0, 0, 0};
            int[] expectedCopiedArray = {0, 0, 0, 0, 0};

            assertArrayEquals(expectedMyIntArray, myIntArray);
            assertArrayEquals(expectedCopiedArray, copiedArray);
        }

        @Test
        public void testMethodsPassArraysByReference() {
            int[] expectedArray = {0, 0, 0, 0, 0};
            assertArrayEquals(expectedArray, myIntArray);

            modifyArray(myIntArray);

            expectedArray = new int[]{0, 2, 0, 0, 0};
            assertArrayEquals(expectedArray, myIntArray);
        }

        @Test
        public void testMethodsPassArrayByReferenceUseArrayCopy() {
            int[] expectedArray = {0, 0, 0, 0, 0};
            int[] expectedArrayCopy = {0, 2, 0, 0, 0};
            assertArrayEquals(expectedArray, myIntArray);
            int[] copyOfArray = Arrays.copyOf(myIntArray, myIntArray.length);

            modifyArray(copyOfArray);
            assertArrayEquals(expectedArray, myIntArray);
            assertArrayEquals(expectedArrayCopy, copyOfArray);
        }
    }
}
