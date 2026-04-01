package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTwoDimensionalArrayTest {

    private int[][] array;
    int expected, result;

    @BeforeEach
    public void setUp() {
        array = App.createTwoDimensionalArray(4, 4);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 10 * i + (j + 1);
            }
        }
    }

    @Test
    public void testOuterArrayCapacity() {
        expected = 4;
        result = array.length;
        assertEquals(expected, result);
    }

    @Test
    public void testInnerArrayCapacity() {
        for (int i = 0; i < array.length; i++) {
            int[] innerArray = array[i];
            expected = 4;
            result = innerArray.length;
            assertEquals(expected, result);
        }
    }

    @Test
    public void testEntireTwoDimensionalArray() {
        int[][] expected = {
                {1, 2, 3, 4},
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34}
        };
        assertArrayEquals(expected, array);
    }
}
