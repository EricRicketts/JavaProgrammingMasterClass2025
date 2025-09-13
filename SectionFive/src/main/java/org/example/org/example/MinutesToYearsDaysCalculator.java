package org.example;

public class MinutesToYearsDaysCalculator {
    final static long minutesInHour = 60;
    final static long hoursInDay = 24;
    final static long daysInYear = 365;

    public static String printYearsAndDays(long minutes) {
        if (minutes < 0) {return "Invalid Value";}

        long years = minutes / (daysInYear * hoursInDay * minutesInHour);
        long remainingMinutes =  minutes % (daysInYear * hoursInDay * minutesInHour);
        long days = remainingMinutes / (minutesInHour * hoursInDay);

        return STR."\{minutes} min = \{years} y and \{days} d";
    }
}
