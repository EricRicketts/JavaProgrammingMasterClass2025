package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecondPrimeNumberChallengeTest {

    @Test
    public void testPrimeNumberChallenge() {
        int primeNumberCounter = 0;
        int[] numbers = new int[]{6, 8, 9, 11, 20, 23, 30, 31, 40, 41, 50};
        int[] expected = new int[]{11, 23, 31};
        int[] resultingPrimes = new int[]{0, 0, 0};

        for (int i = 0; i < numbers.length; i++) {
            int number =  numbers[i];
            if (PrimeNumberChallenge.isPrime(number)) {
                resultingPrimes[primeNumberCounter] = number;
                primeNumberCounter++;
                if (primeNumberCounter > 2) {break;}
            }
        }
        Assertions.assertArrayEquals(expected, resultingPrimes);
        Assertions.assertEquals(3, primeNumberCounter);
    }
}
