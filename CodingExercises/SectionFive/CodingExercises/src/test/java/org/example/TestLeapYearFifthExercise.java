package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLeapYearFifthExercise {

    int[] notLeapYearArray = {
        1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600
    };
    int[] isLeapYearArray = {
        1600, 1704, 1752, 1816, 1860, 1944, 2000, 2400
    };

    @Test
    public void testNotLeapYear() {
        for (int notLeapYear : notLeapYearArray) {
            boolean result = LeapYear.isLeapYear(notLeapYear);
            assertFalse(result);
        }
    }

    @Test
    public void testIsLeapYear() {
        for (int isLeapYear : isLeapYearArray) {
            boolean result = LeapYear.isLeapYear(isLeapYear);
            assertTrue(result);
        }
    }
}
