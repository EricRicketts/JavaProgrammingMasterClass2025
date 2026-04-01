package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinimumTest {

    int[][] integers = {{10, 100, 30, 50, 200, 3, 4, 5}, {45, 25, 98, 0, -1, 32}};
    int expected, result;

    @Test
    public void testFirstSetOfIntegers() {
        expected = 3;
        result = ArrayWork.findMin(integers[0]);
        assertEquals(expected, result);
    }

    @Test
    public void testSecondSetOfIntegers() {
        expected = -1;
        result = ArrayWork.findMin(integers[1]);
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
