package org.example;

public class SumOddRange {

    public static boolean isOdd(int number) {
        return (number > 0 && number % 2 != 0);
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (end < start || start < 0) return -1;
        // if start is negative return -1
        // if both start and end are negative then start is negative so return -1
        // if end is negative and start is positive then end < start so return -1
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {sum += i;}
        }
        return sum;
    }
}
