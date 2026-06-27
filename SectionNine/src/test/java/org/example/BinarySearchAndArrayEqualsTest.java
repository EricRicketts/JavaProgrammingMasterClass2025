package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchAndArrayEqualsTest {

    String[] stringArray = {"Able", "Jane", "Wendy", "Mark", "Ralph", "David", "Eric"};
    int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Nested
    @DisplayName("test binary search")
    class TestBinarySearch {

        @Test
        public void testSortingStringArrayAlphabetizesArray() {
            String[] expected =
                {"Able", "David", "Eric", "Jane", "Mark", "Ralph", "Wendy"};
            Arrays.sort(stringArray);

            assertArrayEquals(expected, stringArray);
        }

        @Test
        public void testUseBinarySearchToFindElementInSortedArray() {
            String name = "Jane";
            Arrays.sort(stringArray);
            // The array must be sorted before running the binary search.
            int foundIndex = Arrays.binarySearch(stringArray, name);

            assertEquals(name, stringArray[foundIndex]);
        }
    }
}
