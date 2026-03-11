package org.example;

public class DigitSum {

    public static int sumDigits(int number) {
        if (number <= 0) return -1;
        int sumOfDigits = 0;
        int currentDigit;
        while (number > 0) {
            currentDigit = number % 10;
            sumOfDigits += currentDigit;
            number = number / 10;
        }
        return sumOfDigits;
    }
}
