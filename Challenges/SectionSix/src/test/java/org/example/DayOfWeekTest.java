package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekTest {

    String[] expectedDays = {
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday", "Invalid Day"
    };
    @Test
    public void testDayOfWeek() {
        for (int i = 0; i < 8; i++) {
            String expectedDayOfWeek = expectedDays[i];
            String dayOfWeek = DayOfWeek.getDayOfWeek(i);
            assertEquals(expectedDayOfWeek, dayOfWeek);
        }
    }

    @Test
    public void testDayOfWeekWithIfElse() {
        for (int i = 0; i < 8; i++) {
            String expectedDayOfWeek = expectedDays[i];
            String dayOfWeek = DayOfWeek.getDayOfWeekWithIfElse(i);
            assertEquals(expectedDayOfWeek, dayOfWeek);
        }
    }
}
