package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LastDigitCheckerTest {

    int[] flawedIntegers = {0, 9, 1001};
    int[] validIntegersSetOne = {10, 300, 967};
    int[] validIntegersSetTwo = {256, 598, 345};

    int[] firstIntegerData = {41, 23, 468, 1000};
    int[] secondIntegerData = {22, 32, 173, 67};
    int[] thirdIntegerData = {71, 42, 199, 450};

    boolean[] expectedResults = {true, true, false, true};

    @Test
    public void testValidityCheckerFirstArgument() {
        for (int i = 0; i < flawedIntegers.length; i++) {
            int first = flawedIntegers[i];
            int second = validIntegersSetOne[i];
            int third = validIntegersSetTwo[i];
            boolean result = LastDigitChecker.hasSameLastDigit(first, second, third);
            assertFalse(result);
        }
    }

    @Test
    public void testValidityCheckerSecondArgument() {
        for (int i = 0; i < flawedIntegers.length; i++) {
            int first = validIntegersSetOne[i];
            int second = flawedIntegers[i];
            int third = validIntegersSetTwo[i];
            boolean result = LastDigitChecker.hasSameLastDigit(first, second, third);
            assertFalse(result);
        }
    }

    @Test
    public void testValidityCheckerThirdArgument() {
        for (int i = 0; i < flawedIntegers.length; i++) {
            int first = validIntegersSetOne[i];
            int second = validIntegersSetTwo[i];
            int third = flawedIntegers[i];
            boolean result = LastDigitChecker.hasSameLastDigit(first, second, third);
            assertFalse(result);
        }
    }

    @Test
    public void testForMatchingLastDigits() {
        for (int i = 0; i < expectedResults.length; i++) {
            int first = firstIntegerData[i];
            int second = secondIntegerData[i];
            int third = thirdIntegerData[i];
            boolean expected = expectedResults[i];
            boolean result = LastDigitChecker.hasSameLastDigit(first, second, third);
            assertEquals(expected, result);
        }
    }

}
