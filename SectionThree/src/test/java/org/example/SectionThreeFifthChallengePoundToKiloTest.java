package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SectionThreeFifthChallengePoundToKiloTest {

    double poundToKilo = 0.45359237;
    double kiloToPound = 2.2046226218;

    @Test
    public void testPoundToKiloConversion() {
        int numberOfPounds = 20;
        BigDecimal result = new BigDecimal(numberOfPounds * poundToKilo);
        result = result.setScale(6, BigDecimal.ROUND_DOWN);
        BigDecimal expected = new BigDecimal(numberOfPounds / kiloToPound);
        expected = expected.setScale(6, BigDecimal.ROUND_DOWN);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testResolutionOfMixedDataTypesIntegerAndDouble() {
        int x = 4;
        float y = 5.0F;
        double z = 6.0;

        BigDecimal integerDividedByDouble = new BigDecimal(x / z);
        integerDividedByDouble = integerDividedByDouble.setScale(6, BigDecimal.ROUND_DOWN);
        double expected = 0.666666;
        Assertions.assertEquals(expected, integerDividedByDouble.doubleValue());

        BigDecimal integerDividedByFloat = new BigDecimal(x / y);
        integerDividedByFloat = integerDividedByFloat.setScale(6, BigDecimal.ROUND_DOWN);
        BigDecimal nextExpected = new BigDecimal(0.8000000);
        nextExpected = nextExpected.setScale(6, BigDecimal.ROUND_DOWN);
        Assertions.assertEquals(nextExpected, integerDividedByFloat);
    }
}
