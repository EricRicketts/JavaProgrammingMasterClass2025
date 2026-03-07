package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpeedConverterSecondExercise {

    private static final double[] speedValues = {0.4, 5.6, 30.2, 100.3, 115.1};
    private static final String[] expectedResults = {
            "0.4 km/h = 0 mi/h",
            "5.6 km/h = 3 mi/h",
            "30.2 km/h = 19 mi/h",
            "100.3 km/h = 62 mi/h",
            "115.1 km/h = 72 mi/h",
    };

    @Test
    public void testSpeedConverter() {
        for (int index = 0; index < speedValues.length; index += 1) {
            double speed = speedValues[index];
            String expected = expectedResults[index];
            String result = SpeedConverter.printConversion(speed);
            assertEquals(expected, result);
        }
    }
}
