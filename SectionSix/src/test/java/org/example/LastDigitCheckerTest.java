package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LastDigitCheckerTest {

    @Test
    public void testLastDigitCheckerInvalidNumbers() {
        int[] invalidNumbers = new int[] {9, 1001};
        int[] validNumbers = new int[] {10, 1000};
        for (int number : invalidNumbers) {
            Assertions.assertFalse(LastDigitChecker.isValid(number));
        }
        for (int number : validNumbers) {
            Assertions.assertTrue(LastDigitChecker.isValid(number));
        }
    }

    @Test
    public void testLastDigitCheckerAnyInvalidNumbers() {
        int[] invalidNumbers = new int[] {9, 1001};
        for (int number : invalidNumbers) {
            Assertions.assertFalse(LastDigitChecker.hasSameLastDigit(number, 23, 34));
        }
        for (int number : invalidNumbers) {
            Assertions.assertFalse(LastDigitChecker.hasSameLastDigit(23, number, 34));
        }
        for (int number : invalidNumbers) {
            Assertions.assertFalse(LastDigitChecker.hasSameLastDigit(23, 34, number));
        }
    }
    @Test
    public void testLastDigitCheckerFortyOneTwentyTwoAndSeventyOne() {
        Assertions.assertTrue(LastDigitChecker.hasSameLastDigit(41, 22, 71));
    }

    @Test
    public void testLastDigitCheckerOneHundredThreeTwentyThreeAndSeventyOne() {
        Assertions.assertTrue(LastDigitChecker.hasSameLastDigit(103, 23, 71));
    }

    @Test
    public void testLastDigitCheckerFortyOneNineHundredNinetyFiveAndOneHundredAndFive() {
        Assertions.assertTrue(LastDigitChecker.hasSameLastDigit(41, 995, 105));
    }

    @Test
    public void testLastDigitCheckerNoMatchingLastDigit() {
        Assertions.assertFalse(LastDigitChecker.hasSameLastDigit(12, 34, 56));
    }
}
