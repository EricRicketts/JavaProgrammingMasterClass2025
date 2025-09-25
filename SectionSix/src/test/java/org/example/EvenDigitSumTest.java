package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvenDigitSumTest {
    int expected, result;
    @Test
    public void testSumEvenDigitNumberLessThanZero() {
        expected = -1;
        result = EvenDigitSum.getEvenDigitSum(-22);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSumEvenDigitNumberThreeDigitNumberWithTwoEvenDigits() {
        expected = 4;
        result = EvenDigitSum.getEvenDigitSum(252);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSumEvenDigitNumberOneEvenDigitNumber() {
        expected = 8;
        result = EvenDigitSum.getEvenDigitSum(8);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSumEvenDigitNumberOneOddDigitNumber() {
        expected = 0;
        result = EvenDigitSum.getEvenDigitSum(3);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSumEvenDigitNumberWithTenUniqueDigits() {
        expected = 20;
        result = EvenDigitSum.getEvenDigitSum(1234567890);

        Assertions.assertEquals(expected, result);
    }
}
