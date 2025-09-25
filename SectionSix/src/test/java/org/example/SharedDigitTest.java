package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SharedDigitTest {

    @Test
    public void testSharedDigitFirstDigitLessThanTen() {
        Assertions.assertFalse(SharedDigit.hasSharedDigit(9, 99));
    }

    @Test
    public void testSharedDigitSecondDigitLessThanTen() {
        Assertions.assertFalse(SharedDigit.hasSharedDigit(99, 9));
    }

    @Test
    public void testSharedDigitFirstDigitGreaterThanNinetyNine() {
        Assertions.assertFalse(SharedDigit.hasSharedDigit(100, 99));
    }

    @Test
    public void testSharedDigitSecondDigitGreaterThanNinetyNine() {
        Assertions.assertFalse(SharedDigit.hasSharedDigit(99, 100));
    }

    @Test
    public void testSharedDigitTwelveAndTwentyThree() {
        Assertions.assertTrue(SharedDigit.hasSharedDigit(12, 23));
    }

    @Test
    public void testSharedDigitTwentyFourAndFiftyTwo() {
        Assertions.assertTrue(SharedDigit.hasSharedDigit(24, 52));
    }

    @Test
    public void testSharedDigitFifteenAndFiftyFive() {
        Assertions.assertTrue(SharedDigit.hasSharedDigit(15, 55));
    }

    @Test
    public void testSharedDigitTwentyFourAndThirtyFive() {
        Assertions.assertFalse(SharedDigit.hasSharedDigit(24, 35));
    }
}
