package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNonSymmetricTwoDimensionalArraysTest {

    private int[][] array2D = new int[4][];

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < array2D.length; i++) {
            switch(i) {
                case 0 -> array2D[i] = new int[]{10, 20, 30};
                case 1 -> array2D[i] = new int[]{10, 20, 30, 40};
                case 2 -> array2D[i] = new int[]{10, 20, 30, 40, 50};
                case 3 -> array2D[i] = new int[]{10, 20, 30, 40, 50, 60};
                default -> array2D[i] = new int[]{0};
            }
        }
    }

    @Test
    public void testInitializedArray() {
        int[][] expected = new int[][]{
                {10, 20, 30},
                {10, 20, 30, 40},
                {10, 20, 30, 40, 50},
                {10, 20, 30, 40, 50, 60}
        };
        assertArrayEquals(expected, array2D);
    }

    @Test
    public void testGettingValue() {
        int expected = 40;
        int result = array2D[2][3];
        assertEquals(expected, result);
    }

    @Test
    public void testSettingValues() {
        for (int i = 0; i < array2D[1].length; i++) {
            array2D[1][i] += 1;
        }
        int[] expected = {11, 21, 31, 41};
        int[] result = array2D[1];
        assertArrayEquals(expected, result);
    }
}
