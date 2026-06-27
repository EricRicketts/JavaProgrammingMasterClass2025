package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumTest {
    int expected, result;

    @Nested
    @DisplayName("test read integers")
    class TestReadIntegers {

        @Test
        public void testReadAndProcessStreamOfIntegers() {
            int[] result = ArrayWork.readIntegers(0, 1, 2, 3, 4);
            int[] expected = new int[]{0, 1, 2, 3, 4};

            assertArrayEquals(expected, result);
        }

        @Test
        public void testReadAndProcessSingleInteger() {
            int[] result = ArrayWork.readIntegers(5);
            int[] expected = new int[]{5};

            assertArrayEquals(expected, result);
        }

        @Test
        public void testReadAndProcessIntegerArray() {
            int[] result = ArrayWork.readIntegers(new int[]{0, 1, 2, 3, 4});
            int[] expected = new int[]{0, 1, 2, 3, 4};

            assertArrayEquals(expected, result);
        }

        @Test
        public void testReadAndProcessNoArgument() {
            int[] result = ArrayWork.readIntegers();
            int[] expected = new int[0];

            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test find minimum from set of integers")
    class FindMinimumFromSetOfIntegers {

        @Test
        public void testFirstSetOfIntegers() {
            expected = 3;
            int[] input = ArrayWork.readIntegers(10, 100, 30, 50, 200, 3, 4, 5);
            result = ArrayWork.findMin(input);
            assertEquals(expected, result);
        }

        @Test
        public void testSecondSetOfIntegers() {
            expected = -1;
            int[] input = ArrayWork.readIntegers(45, 25, 98, 0, -1, 32);
            result = ArrayWork.findMin(input);
            assertEquals(expected, result);
        }

        @Test
        public void testRandomArray() {
            int[] integers = ArrayWork.getRandomArray(100);
            int minimum = ArrayWork.findMin(integers);
            for (int currentInteger : integers) {
                assertTrue(minimum <= currentInteger);
            }
        }
    }

    @Nested
    @DisplayName("test find minimum integer with my new method")
    class TestFindIntegerMinimum {

        @Test
        public void testFirstSetOfIntegers() {
            expected = 3;
            int[] input = ArrayWork.readIntegers(10, 100, 30, 50, 200, 3, 4, 5);
            result = ArrayWork.myFindMin(input);
            assertEquals(expected, result);
        }

        @Test
        public void testSecondSetOfIntegers() {
            expected = -1;
            int[] input = ArrayWork.readIntegers(45, 25, 98, 0, -1, 32);
            result = ArrayWork.myFindMin(input);
            assertEquals(expected, result);
        }

        @Test
        public void testRandomArray() {
            int[] integers = ArrayWork.getRandomArray(100);
            int minimum = ArrayWork.myFindMin(integers);
            for (int currentInteger : integers) {
                assertTrue(minimum <= currentInteger);
            }
        }
    }
}
