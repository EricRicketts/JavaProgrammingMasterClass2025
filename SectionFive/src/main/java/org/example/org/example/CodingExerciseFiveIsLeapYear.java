package org.example;

public class CodingExerciseFiveIsLeapYear {

    public boolean isLeapYear(int year) {
        boolean leap;
        if (year < 1 || year > 9999) { leap = false; }
        else {
            leap = (year % 4 == 0 &&  year % 100 != 0) || (year % 400 == 0);
        }
        return leap;
    }
}
