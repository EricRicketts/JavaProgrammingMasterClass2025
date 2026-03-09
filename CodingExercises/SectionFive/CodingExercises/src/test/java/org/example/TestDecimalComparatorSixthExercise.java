package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDecimalComparatorSixthExercise {

    double[] firstNumberArray = {-3.1756, 3.175, 3.0, -3.123, 5.23, 0.223};
    double[] secondNumberArray = {-3.175, 3.176, 3.0, 3.123, 5.2, 0.2234};
    boolean[] expectedResultsArray = {true, false, true, false, false, true};

    @Test
    public void testDecimalComparator() {
        for (int index = 0; index < firstNumberArray.length; index += 1) {
            double firstNumber = firstNumberArray[index];
            double secondNumber = secondNumberArray[index];
            boolean expected = expectedResultsArray[index];

            boolean result =
                    DecimalComparator.areEqualByThreeDecimalPlaces(firstNumber, secondNumber);
            assertEquals(expected, result);
        }
    }
}
