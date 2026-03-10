package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberInWordTest {
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String[] numbersInWords = {
            "ZERO", "ONE", "TWO", "THREE",
            "FOUR", "FIVE", "SIX", "SEVEN",
            "EIGHT", "NINE", "OTHER"
    };

    @Test
    public void testNumbersInWords() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String expectedWord = numbersInWords[i];
            String resultantWord = NumberInWord.printNumberInWord(number);
            assertEquals(expectedWord, resultantWord);
        }
    }
}
