package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseTest {

    int[] original, expected, result;

    @Test
    public void testReverseEvenArray() {
        original = new int[]{0, 1, 2, 3, 4, 5};
        expected = new int[]{5, 4, 3, 2, 1, 0};
        result = ArrayWork.reverse(original);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverseOddArray() {
        original = new int[]{0, 1, 2, 3, 4, 5, 6};
        expected = new int[]{6, 5, 4, 3, 2, 1, 0};
        result = ArrayWork.reverse(original);
        assertArrayEquals(expected, result);
    }
}
