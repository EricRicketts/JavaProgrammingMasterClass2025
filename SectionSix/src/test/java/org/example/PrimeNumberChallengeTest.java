package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeNumberChallengeTest {

    @Test
    public void testPrimeNumberChallenge() {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 17, 18};
        boolean[] expectedResults = new boolean[]{
                false, false, true, true, false,
                true, true, false
        };
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean expected = expectedResults[i];
            boolean result = PrimeNumberChallenge.isPrime(number);

            Assertions.assertEquals(expected, result);
        }
    }
}
