package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNonSymmetricTwoDimensionalArraysTest {

    private final int[][] array2D = new int[4][];
    private final Object[] array2DObject = new Object[2][];

    @BeforeEach
    public void setUp() {
        BigDecimal[] bigDecimalArray = {
            new BigDecimal("34.55"),
            new BigDecimal("12.34"),
            new BigDecimal("23.45")
        };
        String[] stringArray = {"first", "second", "third", "fourth"};
        for (int i = 0; i < array2D.length; i++) {
            switch(i) {
                case 0 -> array2D[i] = new int[]{10, 20, 30};
                case 1 -> array2D[i] = new int[]{10, 20, 30, 40};
                case 2 -> array2D[i] = new int[]{10, 20, 30, 40, 50};
                case 3 -> array2D[i] = new int[]{10, 20, 30, 40, 50, 60};
                default -> array2D[i] = new int[]{0};
            }
        }
        array2DObject[0] = bigDecimalArray;
        array2DObject[1] = stringArray;
    }

    @Nested
    @DisplayName("test initializing non symmetric 2D array")
    class TestInitializeNonSymmetric2DArray {

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
    }

    @Nested
    @DisplayName("test getters and setters non symmetric 2D array")
    class TestGettersAndSettersNonSymmetric2DArray {

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

    @Nested
    @DisplayName("test get values from 2D object array")
    class TestGetValues2DObjectArray {

        @Test
        public void testGetFirstRowFromObjectArray() {
            BigDecimal[] expected = {
                new BigDecimal("34.55"),
                new BigDecimal("12.34"),
                new BigDecimal("23.45")
            };

            BigDecimal[] result = (BigDecimal[]) array2DObject[0];
            assertArrayEquals(expected, result);
        }

        @Test
        public void testGetSecondRowFromObjectArray() {
            String[] expected = {"first", "second", "third", "fourth"};

            String[] result = (String[]) array2DObject[1];
            assertArrayEquals(expected, result);
        }
    }
}
