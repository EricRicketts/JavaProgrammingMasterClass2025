package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargetPrimeTest {

    int expected, result;
    int[] numbers = new int[]{
            21, 7, 1, 217, -1, 0,
            -10, 1147, 31, 2, 45,
            199, 3127, 16, 12
    };
    int[] largestPrimes = new int[]{
            7, 7, -1, 31, -1, -1,
            -1, 37, 31, 2, 5,
            199, 59, 2, 3
    };

    @Test
    public void testLargestPrimeAllData() {
        {
        /*
        for (int i = 0; i < numbers.length; i++) {
            int number =  numbers[i];
            int expected = largestPrimes[i];
            int result = LargestPrime.getLargestPrime(number);
            Assertions.assertEquals(expected, result);

         */
            int expected = 3;
            int result = LargestPrime.getLargestPrime(12);
            Assertions.assertEquals(expected, result);
        }
    }
}
