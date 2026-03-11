package org.example;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) return -1;
        int remainingNumber = number;
        int lastDigit = 0, firstDigit = 0;
        while (remainingNumber > 0) {
            if (remainingNumber == number) lastDigit = remainingNumber % 10;
            if (remainingNumber < 10 && remainingNumber > 0) firstDigit = remainingNumber % 10;
            remainingNumber = remainingNumber / 10;
        }
        return firstDigit + lastDigit;
    }
}
