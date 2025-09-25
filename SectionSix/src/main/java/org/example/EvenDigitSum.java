package org.example;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {
        if (number < 0) { return -1; }
        int evenDigitSum = 0;

//        while (number >= 10) {
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 == 0) { evenDigitSum += currentDigit; }
            number  = number / 10;
        }
//        if (number % 2 == 0) { evenDigitSum += number; }
        return evenDigitSum;
    }
}
