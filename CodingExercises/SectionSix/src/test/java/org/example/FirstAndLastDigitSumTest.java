package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstAndLastDigitSumTest {

    @Test
    public void testFirstAndLastDigitSum() {
        int[] numbers = {-10, 0, 5, 252, 267, 3007};
        int[] expectedValues = {-1, 0, 10, 4, 9, 10};
        for (int i = 0; i < numbers.length; i++) {
            int expected = expectedValues[i];
            int number = numbers[i];
            int result = FirstLastDigitSum.sumFirstAndLastDigit(number);
            assertEquals(expected, result);
        }
    }
}
