package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DayOfWeekTest {

    @Test
    public void testDayOfWeek() {
        int[] daysOfWeekByNumber = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        String[] daysOfWeekByString = new String[]{
                "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Invalid day"
        };

        for (int index = 0; index < daysOfWeekByNumber.length; index++) {
            int dayOfWeekByNumber =  daysOfWeekByNumber[index];
            String dayOfWeekByString = daysOfWeekByString[index];
            String result = EnhancedSwitchStatementChallenge.printDayOfWeek(dayOfWeekByNumber);

            Assertions.assertEquals(dayOfWeekByString, result);
        }
    }
}
