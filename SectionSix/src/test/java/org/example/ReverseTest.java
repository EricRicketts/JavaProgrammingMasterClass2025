package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseTest {

    int expected, result;
    @Test
    public void testReverseOneHundredAndTwentyThree() {
        expected = 321;
        result = NumberToWords.reverse(123);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReverseNegativeTwoHundredAndThirtyFour() {
        expected = -432;
        result = NumberToWords.reverse(-234);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReverseNegativeOneHundredAndTwentyOne() {
        expected = -121;
        result = NumberToWords.reverse(-121);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReverseOneThousandAndOne() {
        expected = 1001;
        result = NumberToWords.reverse(1001);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReverseFiftyFour() {
        expected = 45;
        result = NumberToWords.reverse(54);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReverseNine() {
        expected = 9;
        result = NumberToWords.reverse(9);
        Assertions.assertEquals(expected, result);
    }
}
