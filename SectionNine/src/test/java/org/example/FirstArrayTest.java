package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstArrayTest {

    private final int[] firstArray = new int[10];
    private BigDecimal[] secondArray;

    private int expectedInt, resultantInt;
    private BigDecimal expectedBigDecimal, resultantBigDecimal;

    @BeforeEach
    public void setUp() {
        for(int i = 0; i < firstArray.length; i++) {
            firstArray[i] = 2*i + 1;
        }
        secondArray = new BigDecimal[]{
                new BigDecimal("0.12"),
                new BigDecimal("1.23"),
                new BigDecimal("2.45"),
                new BigDecimal("3.67"),
                new BigDecimal("4.89"),
                new BigDecimal("5.01")
        };
    }

    @Nested
    @DisplayName("test declaring and initializing arrays")
    class TestDeclaringAndInitializingArrays {

        @Test
        public void testDeclareAndInitializeArrayInOneStatement() {
            int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            assertEquals(10, intArray.length);
            assertEquals(5, intArray[5]);
        }

        @Test
        public void testDeclareArrayAndInitializeAfterDeclaration() {
            int[] intArray;
            intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            assertEquals(10, intArray.length);
            assertEquals(7, intArray[7]);
        }
    }

    @Nested
    @DisplayName("test length and query of first array")
    class TestLengthAndFirstArrayQuery {

        @Test
        public void testFirstArrayLength() {
            assertEquals(10, firstArray.length);
        }

        @Test
        public void testFirstArrayQuery() {
            assertEquals(7, firstArray[3]);
        }
    }

    @Nested
    @DisplayName("test length and query of second array")
    class TestLengthAndSecondArrayQuery {

        @Test
        public void testSecondArrayLength() {
            assertEquals(6, secondArray.length);
        }

        @Test
        public void testNumberFromSecondArray() {
            expectedBigDecimal = new BigDecimal("3.67");
            resultantBigDecimal = secondArray[3];
            assertEquals(expectedBigDecimal, resultantBigDecimal);
        }
    }

    @Nested
    @DisplayName("initialize an array via a loop")
    class InitializeArrayWithLoop {

        @Test
        public void initializeArrayWithLoopQueryArray() {
            int[] intArray = new int[10]; // declared array
            for(int index = 0; index < intArray.length; index++) {
                intArray[index] = 3*index + 1;
            }

            assertEquals(1, intArray[0]);
            assertEquals(13, intArray[4]);
            assertEquals(16, intArray[5]);
            assertEquals(28, intArray[9]);
        }
    }
}
