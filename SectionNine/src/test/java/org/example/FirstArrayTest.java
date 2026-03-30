package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstArrayTest {

    private final int[] firstArray = new int[10];
    private double[] secondArray;

    private int expectedInt, resultantInt;
    private double expectedDouble, resultantDouble;

    @BeforeEach
    public void setUp() {
        for(int i = 0; i < firstArray.length; i++) {
            firstArray[i] = 2*i + 1;
        }
        secondArray = new double[]{0.12, 1.23, 2.45, 3.67, 4.89, 5.01};
    }

    @Test
    public void testMemberFromFirstArray() {
        expectedInt = 7;
        resultantInt = firstArray[3];
        assertEquals(expectedInt, resultantInt);
    }

    @Test
    public void testLengthOfFirstArray() {
        expectedInt = 10;
        resultantInt = firstArray.length;
        assertEquals(expectedInt, resultantInt);
    }

    @Test
    public void testNumberFromSecondArray() {
        expectedDouble = 3.67;
        resultantDouble = secondArray[3];
        assertEquals(expectedDouble, resultantDouble);
    }

    @Test
    public void testAnotherNumberFromSecondArray() {
        expectedDouble = 5.01;
        resultantDouble = secondArray[secondArray.length - 1];
        assertEquals(expectedDouble, resultantDouble);
    }

}
