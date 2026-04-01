package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateTwoDimensionalArrayTest {

    private int[][] array;
    int expected, result;

    @BeforeEach
    public void setUp() {
        array = App.createTwoDimensionalArray(4, 4);
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
}
