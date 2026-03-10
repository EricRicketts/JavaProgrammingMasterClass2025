package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekTest {

    @Test
    public void testDayOfWeek() {
        for (int i = 0; i < 8; i++) {
            String[] expectedDays = {
                    "Monday", "Tuesday", "Wednesday", "Thursday",
                    "Friday", "Saturday", "Sunday", "Invalid Day"
            };
            String expectedDayOfWeek = expectedDays[i];
            String dayOfWeek = DayOfWeek.getDayOfWeek(i);
            assertEquals(expectedDayOfWeek, dayOfWeek);
        }
    }
}
