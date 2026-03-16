package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestPrimeTest {

    int[] invalidNumbers = {-1, 0, 1};
    int[] numbers = {2, 6, 21, 45, 217, 466};
    int[] largestPrimes = {2, 3, 7, 5, 31, 233};

    @Test
    public void testInvalidInputs() {
        for (int number : invalidNumbers) {
            int result = LargestPrime.getLargestPrime(number);

            assertEquals(-1, result);
        }
    }

    @Test
    public void testGetLargestPrime() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int expected = largestPrimes[i];
            int result = LargestPrime.getLargestPrime(number);

            assertEquals(expected, result);
        }
    }
}
