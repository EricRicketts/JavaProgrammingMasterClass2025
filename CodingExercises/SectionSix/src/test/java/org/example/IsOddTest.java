package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsOddTest {

    int[] oddNumbers = {3, 11, 33};
    int[] evenNumbers = {2, 10, 30};

    @Test
    public void testOddRNumbers() {
        for (int i = 0; i < oddNumbers.length; i++) {
            int oddNumber = oddNumbers[i];
            assertTrue(SumOddRange.isOdd(oddNumber));
        }
    }

    @Test
    public void testEvenNumbers() {
        for (int i = 0; i < evenNumbers.length; i++) {
            int evenNumber = evenNumbers[i];
            assertFalse(SumOddRange.isOdd(evenNumber));
        }
    }
}
