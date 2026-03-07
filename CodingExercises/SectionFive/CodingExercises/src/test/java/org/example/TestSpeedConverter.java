package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpeedConverter {
    double[] speedValues = new double[] {1.5, 10.25, -5.6, 25.42, 75.114};

    @Test
    public void testMilesPerHour() {
        long[] expectedResults = new long[] {1, 6, -1, 16, 47};
        for (int index = 0; index < speedValues.length; index += 1) {
            double speed = speedValues[index];
            long result = SpeedConverter.toMilesPerHour(speed);
            assertEquals(expectedResults[index], result);
        }
    }

    @Test
    public void testPrintConversion() {
        String[] expectedResults = new String[] {
                "1.5 km/h = 1 mi/h",
                "10.25 km/h = 6 mi/h",
                "Invalid Value",
                "25.42 km/h = 16 mi/h",
                "75.114 km/h = 47 mi/h"
        };
        for (int index = 0; index < expectedResults.length; index += 1) {
            String result = SpeedConverter.printConversion(speedValues[index]);
            assertEquals(expectedResults[index], result);
        }
    }
}
