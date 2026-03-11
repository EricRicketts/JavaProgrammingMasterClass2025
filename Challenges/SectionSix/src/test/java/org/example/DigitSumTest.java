package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

    int[] expectedSums = {-1, 7, 1, 8, 10, 33}, numbers = {0, 7, 1000, 125, 1234, 3450678};

    @Test
    public void testSumDigits() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int expectedSum = expectedSums[i];
            int sum = DigitSum.sumDigits(number);
            assertEquals(expectedSum, sum);
        }
    }
}
