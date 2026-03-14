package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWordsTest {

    int[] numbers = {-12, 123, 1010, 1000, 3405600};
    String[] expectedPhrases = {
            "Invalid Value",
            "One Two Three",
            "One Zero One Zero",
            "One Zero Zero Zero",
            "Three Four Zero Five Six Zero Zero"
    };

    @Test
    public void testNumberToWords() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String expected = expectedPhrases[i];
            String result = NumberToWords.numberToWords(number);
            assertEquals(expected, result);
        }
    }
}
