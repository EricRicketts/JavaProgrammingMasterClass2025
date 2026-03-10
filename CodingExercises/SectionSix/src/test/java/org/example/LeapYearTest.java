package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTest {

    @Test
    public void testValidLeapYears() {
        int[] validLeapYears = {1504, 1600, 1756, 1836, 1944, 2000};

        for (int year : validLeapYears) {
            assertTrue(NumberOfDaysInMonth.isLeapYear(year));
        }
    }

    @Test
    public void testInvalidLeapYears() {
        int[] invalidLeapYears = {1700, 1800, 1890, 1900, 1950, 2018};

        for (int year : invalidLeapYears) {
            assertFalse(NumberOfDaysInMonth.isLeapYear(year));
        }
    }
}
