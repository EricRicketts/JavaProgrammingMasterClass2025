package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerfectNumberTest {

    boolean expected, result;

    @Test
    public void testNumberLessThanOne() {
        result = PerfectNumber.isPerfectNumber(-1);

        Assertions.assertFalse(result);
    }

    @Test
    public void testNumberSix() {
        result = PerfectNumber.isPerfectNumber(6);

        Assertions.assertTrue(result);
    }

    @Test
    public void testNumberTwentyEight() {
        result = PerfectNumber.isPerfectNumber(28);

        Assertions.assertTrue(result);
    }

    @Test
    public void testNumberFive() {
        result = PerfectNumber.isPerfectNumber(5);

        Assertions.assertFalse(result);
    }

    @Test
    public void testNumberFourHundredAndNinetySix() {
        result = PerfectNumber.isPerfectNumber(496);

        Assertions.assertTrue(result);
    }
}
