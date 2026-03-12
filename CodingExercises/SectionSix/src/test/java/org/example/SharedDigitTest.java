package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharedDigitTest {
    int[] firstNumbers = {12, 9, 43, 15, 12, 30, 98};
    int[] secondNumbers = {23, 99, 5, 55, 56, 40, 76};
    boolean[] expectedResults = {true, false, false, true, false, true, false};

    @Test
    public void testSharedDigit() {
        for (int i = 0; i < expectedResults.length; i++) {
            int firstNumber = firstNumbers[i];
            int secondNumber = secondNumbers[i];
            boolean expected = expectedResults[i];
            boolean result = SharedDigit.hasSharedDigit(firstNumber, secondNumber);
            assertEquals(expected, result);
        }
    }
}
