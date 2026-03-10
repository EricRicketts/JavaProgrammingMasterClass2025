package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDaysInMonthTest {
    int[] months;
    int daysInMonth;
    @Test
    public void testTheLongerMonths() {
        months = new int[]{1, 3, 5, 7, 8, 10, 12};
        for (int i = 0; i < months.length; i++) {
            daysInMonth = NumberOfDaysInMonth.getDaysInMonth(months[i], 2023);
            assertEquals(31, daysInMonth);
        }
    }

    @Test
    public void testTheShorterMonths() {
        months = new int[]{4, 6, 9, 11};
        for (int i = 0; i < months.length; i++) {
            daysInMonth = NumberOfDaysInMonth.getDaysInMonth(months[i], 2023);
            assertEquals(30, daysInMonth);
        }
    }

    @Test
    public void testDaysInMonthForLeapYear() {
        months = new int[]{2};
        daysInMonth = NumberOfDaysInMonth.getDaysInMonth(months[0], 1912);
        assertEquals(29, daysInMonth);
    }

    @Test
    public void testDaysInMonthForNonLeapYear() {
        months = new int[]{2};
        daysInMonth = NumberOfDaysInMonth.getDaysInMonth(months[0], 1922);
        assertEquals(28, daysInMonth);
    }
}