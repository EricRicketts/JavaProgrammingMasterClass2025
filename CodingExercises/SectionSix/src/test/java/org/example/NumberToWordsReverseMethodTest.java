package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWordsReverseMethodTest {

    int[] numbersForReverse = {0, -121, 1212, 1234, 100, 567, 2030};
    int[] expectedReversedNumbers = {0, -121, 2121, 4321, 1, 765, 302};

    @Test
    public void testReverse() {
        for (int i = 0; i < numbersForReverse.length; i++) {
            int number = numbersForReverse[i];
            int expected = expectedReversedNumbers[i];
            int result = NumberToWords.reverse(number);

            assertEquals(expected, result);
        }
    }
}
