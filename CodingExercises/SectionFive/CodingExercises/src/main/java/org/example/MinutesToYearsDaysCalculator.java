package org.example;

public class MinutesToYearsDaysCalculator {

    public static final long MINUTES_PER_HOUR = 60;
    public static final long HOURS_PER_DAY = 24;
    public static final long DAYS_PER_YEAR = 365;
    public static String printYearsAndDays(long minutes) {
        long years = minutes / (MINUTES_PER_HOUR * HOURS_PER_DAY * DAYS_PER_YEAR);
        long leftOverYearsInMinutes = minutes % (MINUTES_PER_HOUR * HOURS_PER_DAY * DAYS_PER_YEAR);
        long days = leftOverYearsInMinutes / (MINUTES_PER_HOUR * HOURS_PER_DAY);

        return minutes + " min = " + years + " y and " + days + " d";
    }
}
