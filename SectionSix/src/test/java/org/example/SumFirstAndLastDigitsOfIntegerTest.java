package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumFirstAndLastDigitsOfIntegerTest {
    int expected, results;

    @Test
    public void testSumFirstAndLastDigitsOfIntegerFirst() {
        expected = 4;
        results = FirstLastDigitSum.sumFirstAndLastDigit(252);

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testSumFirstAndLastDigitsOfIntegerSecond() {
        expected = -1;
        results = FirstLastDigitSum.sumFirstAndLastDigit(-10);

        Assertions.assertEquals(expected, results);
    }
}
