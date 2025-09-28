package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberToWordsTest {

    String expected, result;
    @Test
    public void testNumberLessThanZero() {
        expected = "Invalid Value";
        result = NumberToWords.numberToWords(-10);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testZero() {
        expected = "Zero";
        result = NumberToWords.numberToWords(0);

        Assertions.assertEquals(expected, result);
    }
}
