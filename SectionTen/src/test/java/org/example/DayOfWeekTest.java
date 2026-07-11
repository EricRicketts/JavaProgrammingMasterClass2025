package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.DayOfWeek.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayOfWeekTest {

    public static String switchDayOfWeek(DayOfWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        return switch(weekDay) {
            case SUNDAY -> "Sunday is Day " + weekDayInteger;
            case MONDAY -> "Monday is Day " + weekDayInteger;
            case TUESDAY -> "Tuesday is Day " + weekDayInteger;
            case WEDNESDAY -> "Wednesday is Day " + weekDayInteger;
            case THURSDAY -> "Thursday is Day " + weekDayInteger;
            case FRIDAY -> "Friday is Day " + weekDayInteger;
            case SATURDAY -> "Saturday is Day " + weekDayInteger;
        };
    }

    public static DayOfWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfWeek.values();

        return allDays[randomInteger];
    }

    @Test
    public void testGetEnumValue() {
        DayOfWeek dayOfWeek = TUESDAY;

        assertEquals(TUESDAY, dayOfWeek);
        assertEquals("TUESDAY", dayOfWeek.toString());
    }

    @Test
    public void testEnumName() {
        DayOfWeek dayOfWeek = WEDNESDAY;

        assertEquals("WEDNESDAY", dayOfWeek.name());
    }

    @Test
    public void testEnumOrdinalValue() {
        DayOfWeek dayOfWeek = WEDNESDAY;

        assertEquals(
            3, dayOfWeek.ordinal());
    }

    @Test
    public void testGetRandomDayName() {
        DayOfWeek dayOfWeek = getRandomDay();

        List<String> dayOfWeekStrings = List.of("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
            "THURSDAY", "FRIDAY", "SATURDAY");

        assertTrue(dayOfWeekStrings.contains(dayOfWeek.name()));
    }

    @Test
    public void testGetRandomDayOrdinalValue() {
        DayOfWeek dayOfWeek = getRandomDay();

        List<Integer> dayOfWeekOrdinalValues = List.of(0, 1, 2, 3, 4, 5, 6);

        assertTrue(dayOfWeekOrdinalValues.contains(dayOfWeek.ordinal()));
    }

    @Test
    public void testSwitchDayOfWeek() {
        DayOfWeek[] daysOfWeek = {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
        String[] expectedString = {
            "Sunday is Day 1",
            "Monday is Day 2",
            "Tuesday is Day 3",
            "Wednesday is Day 4",
            "Thursday is Day 5",
            "Friday is Day 6",
            "Saturday is Day 7"
        };
        for (int index = 0; index < daysOfWeek.length; index++) {
            DayOfWeek dayOfWeek = daysOfWeek[index];
            String expected = expectedString[index];
            String result = switchDayOfWeek(dayOfWeek);

            assertEquals(expected, result);
        }
    }
}