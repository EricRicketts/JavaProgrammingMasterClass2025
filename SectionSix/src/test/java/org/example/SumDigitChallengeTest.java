package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumDigitChallengeTest {
    public static int sumDigitChallenge(int number) {
       if (number < 0) return -1;
       int sumOfDigits = 0;
       int remainder = 0;
       int dividend = number;
       while (dividend != 0) {
           remainder = dividend % 10;
           sumOfDigits += remainder;
           dividend /= 10;
       }
       return sumOfDigits;
    }

    @Test
    public void testSumDigitChallengeNumberLessThanZero() {
        Assertions.assertEquals(-1, sumDigitChallenge(-1));
    }

    @Test
    public void testSumDigitChallengeNumberGreaterThanZeroButLessThanTen() {
        Assertions.assertEquals(7, sumDigitChallenge(7));
    }

    @Test
    public void testSumDigitChallengeTwoDigitNumber() {
        Assertions.assertEquals(5, sumDigitChallenge(23));
    }

    @Test
    public void testSumDigitChallengeOneHundred() {
        Assertions.assertEquals(1, sumDigitChallenge(100));
    }

    @Test
    public void testSumDigitChallengeOneFourDigitNumber() {
        Assertions.assertEquals(10, sumDigitChallenge(1234));
    }
}
