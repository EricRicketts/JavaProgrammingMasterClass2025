package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversionTest {

    int[] inchesOnly = {3, 4, 20};
    double[] centimetersForInchesOnly = {7.62, 10.16, 50.80};

    int[] feetArray = {1, 2, 3};
    int[] inchesArray = {11, 4, 9};

    double[] centimetersForFeetAndInches = {58.42, 71.12, 114.30};

    @Test
    public void testInchesOnly() {
        for (int index = 0; index < inchesOnly.length; index += 1) {
            int inches = inchesOnly[index];
            double result = Conversion.convertToCentimeters(inches);
            double expected = centimetersForInchesOnly[index];
            assertEquals(expected, result);
        }
    }

    @Test
    public void testFeetAndInches() {
        for (int index = 0; index < feetArray.length; index += 1) {
            int feet = feetArray[index];
            int inches = inchesArray[index];
            double expected = centimetersForFeetAndInches[index];
            double result = Conversion.convertToCentimeters(feet, inches);
            assertEquals(expected, result);
        }
    }
}
