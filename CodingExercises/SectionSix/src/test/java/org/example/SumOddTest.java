package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOddTest {
    int start = 1, end = 11, expectedSum = 36, invalidInput = -1;

    @Test
    public void testSumOddIntegersOverARange() {
        int sum = SumOddRange.sumOdd(start, end);
        assertEquals(expectedSum, sum);
    }

    @Test
    public void testEndIsLessThanStart() {
        int sum = SumOddRange.sumOdd(4, 3);
        assertEquals(invalidInput, sum);
    }

    @Test
    public void testStartLessThanZero() {
        int sum = SumOddRange.sumOdd(-1, 3);
        assertEquals(invalidInput, sum);
    }

    @Test
    public void testEndLessThanZero() {
        int sum = SumOddRange.sumOdd(2, -1);
        assertEquals(invalidInput, sum);
    }
}
