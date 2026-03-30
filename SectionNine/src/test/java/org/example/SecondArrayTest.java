package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondArrayTest {

    private int[] array;
    int expected, result;

    @BeforeEach
    public void setUp() {
        array = new int[10];
        // Populate the array in reverse order of its indices, i.e., array[0] = 10, ... , array[9] = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    @Test
    public void testSecondElement() {
        expected = 9;
        result = array[1];
        assertEquals(expected, result);
    }

    @Test
    public void testLastElement() {
        expected = 1;
        result = array[array.length - 1];
        assertEquals(expected, result);
    }

    @Test
    public void testBuiltInPrintArrayMethod() {
        String expected = "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]";
        String result = Arrays.toString(array);
        assertEquals(expected, result);
    }
}
