package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinutesToYearsDaysCalculator {

    long[] minutesArray = {525600, 1051200, 561600, 36000};
    String[] expectedArray = {
            "525600 min = 1 y and 0 d",
            "1051200 min = 2 y and 0 d",
            "561600 min = 1 y and 25 d",
            "36000 min = 0 y and 25 d"
    };

    @Test
    public void testPrintYearsAndDays() {
        for (int index = 0; index < minutesArray.length; index++) {
            long minutes = minutesArray[index];
            String expected = expectedArray[index];
            String result = MinutesToYearsDaysCalculator.printYearsAndDays(minutes);
            assertEquals(expected, result);
        }
    }

}
