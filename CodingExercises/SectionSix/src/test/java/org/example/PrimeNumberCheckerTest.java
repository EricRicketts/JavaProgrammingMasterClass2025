package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberCheckerTest {

    int[] numbers = {2, 3, 4, 5, 11, 15, 99, 103};
    boolean[] isPrimeNumberResults = {true, true, false, true, true, false, false, true};

    @Test
    public void testIsPrime() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean expected = isPrimeNumberResults[i];
            boolean result = PrimeNumberChecker.isPrime(number);

            assertEquals(expected, result);
        }
    }
}
