package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    public void testCalculateAgeInteger() {
        int expected = 25;
        int results = AgeCalculator.getAgeInteger("2025", "2000");

        Assertions.assertEquals(expected, results);
    }

    @Test
    public void testCalculateAgeDouble() {
        double expected = 20.4;
        double results = Math.floor(AgeCalculator.getAgeDouble("2025.2", "2004.8") * 10) / 10;

        Assertions.assertEquals(expected, results);
    }
}
