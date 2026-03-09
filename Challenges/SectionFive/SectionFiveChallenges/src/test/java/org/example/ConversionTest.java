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

    @Test
    public void testHoursMinutesAndSecondsSecondsOnly() {
        int[] seconds = {-1, 8125, 50, 3600, 3945};
        String[] expectedMessages = {
                "Invalid entry seconds must be positive.",
                "2h 15m 25s",
                "0h 0m 50s",
                "1h 0m 0s",
                "1h 5m 45s"
        };
        for (int index = 0; index < expectedMessages.length; index += 1) {
            int currentSeconds = seconds[index];
            String expected = expectedMessages[index];
            String result = Conversion.getDurationString(currentSeconds);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testHoursMinutesAndSecondsMinutesAndSeconds() {
        int[] minutes = {0, 59, 121, 65, -10, 5};
        int[] seconds = {59, 55, 25, 11, 13, 61};
        String[] expectedMessages = {
                "0h 0m 59s",
                "0h 59m 55s",
                "2h 1m 25s",
                "1h 5m 11s",
                "Invalid entry minutes must be positive.",
                "Invalid entry seconds must be between 0 and 59."
        };
        for (int index = 0; index < minutes.length; index +=1) {
            int currentMinutes = minutes[index];
            int currentSeconds = seconds[index];
            String expected = expectedMessages[index];
            String result = Conversion.getDurationString(currentMinutes, currentSeconds);
            assertEquals(expected, result);
        }
    }
}
