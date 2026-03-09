package org.example;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        boolean normalLeapYearRule = (year % 4 == 0 && year % 100 != 0);
        boolean hundredLeapYearRule = (year % 100 == 0 && year % 400 == 0);
       if (year < 1 || year > 9999) return false;
       if (normalLeapYearRule || hundredLeapYearRule) isLeap = true;
       return isLeap;
    }
}
