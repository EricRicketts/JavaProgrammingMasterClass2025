package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWordsGetDigitCountMethodTest {

    int[] numbersForDigitCount = {0, 123, -12, 5200, 41032};
    int[] expectedDigitCount = {1, 3, -1, 4, 5};

    @Test
    public void testGetDigitCount() {
        for (int i = 0; i < numbersForDigitCount.length; i++) {
            int number = numbersForDigitCount[i];
            int expected = expectedDigitCount[i];
            int result = NumberToWords.getDigitCount(number);

            assertEquals(expected, result);
        }
    }
}
