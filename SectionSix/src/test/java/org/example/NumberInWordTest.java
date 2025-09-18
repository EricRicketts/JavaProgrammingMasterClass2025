package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberInWordTest {

    @Test
    public void testNumberInWord() {
        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] expectedWords = new String[]{
                "ZERO",
                "ONE",
                "TWO",
                "THREE",
                "FOUR",
                "FIVE",
                "SIX",
                "SEVEN",
                "EIGHT",
                "NINE"
        };

        for (int i = 0; i < numbers.length; i++) {
            int number =  numbers[i];
            String expected = expectedWords[i];
            String result = NumberInWord.numberInWord(number);

            Assertions.assertEquals(expected, result);
        }
    }
}
