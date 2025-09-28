package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberInWordTest {
    String expected, result;

    @Test
    public void testNumberInWordSingleDigit() {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] expectedWords = new String[]{
                "Zero",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine"
        };

        for (int i = 0; i < numbers.length; i++) {
            int number =  numbers[i];
            expected = expectedWords[i];
            result = NumberToWords.numberToWords(number);

            Assertions.assertEquals(expected, result);
        }
    }

    @Test
    public void testNumberInWordOneHundredAndTwentyThree() {
        expected = "One Two Three";
        result =  NumberToWords.numberToWords(123);

        Assertions.assertEquals(expected, result);
    }
}
