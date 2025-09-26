package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreatestCommonDivisorTest {
    int  expected, result;

    @Test
    public void testGreatestCommonDivisorBadInputs() {
        expected = -1;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(9, 10);
        Assertions.assertEquals(expected, result);
        result = GreatestCommonDivisor.getGreatestCommonDivisor(10, 9);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisorTwelveAndThirty() {
        expected = 6;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(12, 30);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisorTwentyFiveAndFifteen() {
        expected = 5;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(25, 15);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisorEightyOneAndOneHundredAndFiftyThree() {
        expected = 9;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(81, 153);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisorFortyTwoAndFiftySix() {
        expected = 14;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(42, 56);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGreatestCommonDivisorFortyEigthAndOneHundredAndEighty() {
        expected = 12;
        result = GreatestCommonDivisor.getGreatestCommonDivisor(48, 180);

        Assertions.assertEquals(expected, result);
    }
}
