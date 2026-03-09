package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEqualSumCheckerSeventhExercise {

    int[] firstNumbersArray = {1, 1, 1, 5, 3};
    int[] secondNumbersArray = {1, 1, -1, 4, -2};
    int[] expectedSumsArray = {1, 2, 0, 10, 1};
    boolean[] expectedResultsArray = {false, true, true, false, true};

    @Test
    public void testEqualSumChecker() {
        for (int index = 0; index < expectedSumsArray.length; index += 1) {
            int firstNumber = firstNumbersArray[index];
            int secondNumber = secondNumbersArray[index];
            int expectedSum = expectedSumsArray[index];
            boolean expected = expectedResultsArray[index];

            boolean result =
                    EqualSumChecker.hasEqualSum(firstNumber, secondNumber, expectedSum);
            assertEquals(expected, result);
        }
    }
}
