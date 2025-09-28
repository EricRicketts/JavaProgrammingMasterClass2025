package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetDigitCountTest {

    int expected, result;
    @Test
    public void testGetDigitCountNegativeNumber() {
        expected = -1;
        result =  NumberToWords.getDigitCount(-5);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneNumber() {
        expected = 1;
        result =  NumberToWords.getDigitCount(0);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneHundredAndTwentyThree() {
        expected = 3;
        result =  NumberToWords.getDigitCount(123);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneThousandFourHundredAndSeventyEight() {
        expected = 4;
        result =  NumberToWords.getDigitCount(1478);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneHundred() {
        expected = 3;
        result =  NumberToWords.getDigitCount(100);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneThousandAndTen() {
        expected = 4;
        result =  NumberToWords.getDigitCount(1010);

        Assertions.assertEquals(expected, result);
    }


}
