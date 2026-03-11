package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberPalindromeTest {

    int[] numbers = {-1221, 88, 707, 1234, 12212};
    boolean[] expectedResults = {true, true, true, false, false};

    @Test
    public void testPalindromeNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean expected = expectedResults[i];
            boolean result = NumberPalindrome.isPalindrome(number);
            assertEquals(expected, result);
        }
    }
}
