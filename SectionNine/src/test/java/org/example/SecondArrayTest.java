package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SecondArrayTest {

    private static int[] getRandomArray(int length) {
        Random random = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100);
        }
        return randomArray;
    }

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

    @Test
    public void testSortRandomArray() {
        array = getRandomArray(10);
        Arrays.sort(array); //  runs in place sort, a new array is not returned
        for (int i = 0; i < array.length - 2; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testCopyingArrays() {
        int[] firstArray = new int[10];
        firstArray = getRandomArray(10);
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);
        // Array copies are equal
        assertArrayEquals(firstArray, secondArray);
        Arrays.sort(firstArray);
        // Sorting the first array does not affect the second array as the object references are different.
        assertFalse(Arrays.equals(firstArray, secondArray));
    }

    @Test
    public void testFillArray() {
        int[] firstArray = new int[5];
        String expected = "[0, 0, 0, 0, 0]";
        String result = Arrays.toString(firstArray);
        assertEquals(expected, result);
        Arrays.fill(firstArray, 5);
        expected = "[5, 5, 5, 5, 5]";
        result = Arrays.toString(firstArray);
        assertEquals(expected, result);
    }

    @Test
    public void testCopyToSmallerArray() {
        int[] smallerArray = Arrays.copyOf(array, 5);
        assertEquals(5, smallerArray.length);
        for(int i = 0; i < smallerArray.length; i++) {
            assertEquals(array[i], smallerArray[i]);
        }
    }
}
