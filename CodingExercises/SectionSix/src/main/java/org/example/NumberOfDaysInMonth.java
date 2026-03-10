package org.example;

public class NumberOfDaysInMonth {

    public static int getDaysInMonth(int month, int year) {
        return switch(month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> -1;
        };
    }
    public static boolean isLeapYear(int year) {
        // A leap year is divisible by 4, but not by 100 unless it is also divisible by 400
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}
