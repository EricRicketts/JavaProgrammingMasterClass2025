package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenDigitSumTest {
    int[] numbers = {-22, 252, 123456789, 30215634};
    int[] expectedSums = {-1, 4, 20, 12};

    @Test
    public void testEvenDigitSum() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int expectedSum = expectedSums[i];
            int result = EvenDigitSum.getEvenDigitSum(number);
            assertEquals(expectedSum, result);
        }
    }
}
