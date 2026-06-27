package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDimensionalArrayTest {

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

    @Nested
    @DisplayName("test symmetrical two dimensional arrays")
    class TestSymmetricalTwoDimensionalArrays {

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

    @Nested
    @DisplayName("create and manipulate symmetric two dimensional arrays")
    class CreateAndManipulateSymmetricTwoDimensionalArrays {

        @Test
        public void testCreateThreeByThreeArray() {
            array = App.createTwoDimensionalArray(3, 3);
            for (int i = 0; i < array.length; i++) {
                int[] innerArray = array[i];
                for (int j = 0; j < innerArray.length; j++) {
                    array[i][j] = i * 2 + j;
                }
            }
            int[][] expectedArray = {
                {0, 1, 2},
                {2, 3, 4},
                {4, 5, 6}
            };

            assertArrayEquals(expectedArray, array);
        }

        @Test
        public void testSetValuesOnAnInnerArrayOfThreeByThreeArray() {
            int[] innerArray = array[3];
            for (int index = 0; index < innerArray.length; index++) {
                innerArray[index] += 1;
                array[3][index] = innerArray[index];
            }
            int[] expected = {32, 33, 34, 35};

            assertArrayEquals(expected, array[3]);
        }

        @Test
        public void testSetValuesOnEntireThreeByThreeArray() {
            for (int i = 0; i < array.length; i++) {
                for(int j = 0; j < array[i].length; j++) {
                    array[i][j] = i * j + 1;
                }
            }
            int[][] expected = {
                {1, 1, 1, 1},
                {1, 2, 3, 4},
                {1, 3, 5, 7},
                {1, 4, 7, 10}
            };

            assertArrayEquals(expected, array);
        }
    }
}
