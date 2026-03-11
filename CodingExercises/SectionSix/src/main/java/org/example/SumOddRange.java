package org.example;

public class SumOddRange {

    public static boolean isOdd(int number) {
        if (number <= 0) return false;
        return !(number % 2 == 0);
    }

    public static int sumOdd(int start, int end) {
        boolean checkInputs = ((end >= start) && (start > 0 && end > 0));
        if (!checkInputs) return -1;
        int sumOfOddNumbers = 0;
        for (int i = start; i <= end; i++) {
            if (SumOddRange.isOdd(i)) sumOfOddNumbers += i;
        }
        return sumOfOddNumbers;
    }
}
