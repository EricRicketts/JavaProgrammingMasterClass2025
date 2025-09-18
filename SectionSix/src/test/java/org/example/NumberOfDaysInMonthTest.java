package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfDaysInMonthTest {

    @Test
    public void testIsLearYear() {
        int[] years = new int[]{-1600, 1600, 2017, 2000};
        boolean[] expectedResults  = new boolean[]{false, true, false, true};

        for (int i = 0; i < years.length; i++) {
            int year =  years[i];
            boolean expected = expectedResults[i];
            boolean result = NumberOfDaysInMonth.isLeapYear(year);

            Assertions.assertEquals(expected, result);
        }
    }

    @Test
    public void testGetDaysInMonth() {
        int[] months = new int[]{1, 2, 2, -1, 1, 4};
        int[] years = new int[]{2020, 2020, 2018, 2020, -2020, 2017};
        int[] expectedDays = new int[]{31, 29, 28, -1, -1, 30};

        for (int i = 0; i < years.length; i++) {
            int month =  months[i];
            int year =  years[i];
            int expected = expectedDays[i];

            int result =  NumberOfDaysInMonth.getDaysInMonth(month, year);
            Assertions.assertEquals(expected, result);
        }
    }
}
