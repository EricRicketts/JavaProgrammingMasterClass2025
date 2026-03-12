package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {

    int expected, result;
    int[] firstNumbers = {32, 25, 12, 81, 12, 144, 5469, 162};
    int[] secondNumbers = {33, 15, 30, 153, 144, 12, 3273, 144};
    int[] greatestCommonDivisors = {1, 5, 6, 9, 12, 12, 3, 18};

    @Test
    public void testInvalidFirstFactor() {
        expected = -1;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(9, 18);
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidSecondFactor() {
        expected = -1;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(20, 5);
        assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisor() {
        for (int i = 0; i < firstNumbers.length; i++) {
            int firstNumber = firstNumbers[i];
            int secondNumber = secondNumbers[i];
            int expected = greatestCommonDivisors[i];
            int result =
                    GreatestCommonDivisor.getGreatestCommonDivisor(firstNumber, secondNumber);
            assertEquals(expected, result);
        }
    }
}
