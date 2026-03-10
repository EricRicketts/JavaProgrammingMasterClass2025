package org.example;

public class DayOfWeek {

    private static final String[] daysOfWeek =
            {       "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday", "Saturday", "Sunday"
            };
    public static String getDayOfWeek(int day) {
        String dayOfWeek = switch (day) {
            case 0 -> {
                yield daysOfWeek[0];
            }
            case 1 -> {
                yield daysOfWeek[1];
            }
            case 2 -> {
                yield daysOfWeek[2];
            }
            case 3 -> {
                yield daysOfWeek[3];
            }
            case 4 -> {
                yield daysOfWeek[4];
            }
            case 5 -> {
                yield daysOfWeek[5];
            }
            case 6 -> {
                yield daysOfWeek[6];
            }
            default -> {
                yield "Invalid Day";
            }
        };
        return dayOfWeek;
    }
}
