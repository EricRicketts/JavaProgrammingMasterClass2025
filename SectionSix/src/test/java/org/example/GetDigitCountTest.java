package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetDigitCountTest {

    String expected, result;
    @Test
    public void testGetDigitCountNegativeNumber() {
        int expected = -1;
        int result =  NumberToWords.getDigitCount(-5);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneNumber() {
        int expected = 1;
        int result =  NumberToWords.getDigitCount(0);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneHundredAndTwentyThree() {
        int expected = 3;
        int result =  NumberToWords.getDigitCount(123);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDigitCountOneThousandFourHundredAndSeventyEight() {
        int expected = 4;
        int result =  NumberToWords.getDigitCount(1478);

        Assertions.assertEquals(expected, result);
    }


}
