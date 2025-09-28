package org.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class NumberToWords {

    public static String digitsToWords(int number) {
        return switch (number) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "Invalid Value";
        };
    }
    public static int getDigitCount(int number) {
        int digitCount = 0;
        if (number < 0) return -1;

        if (number < 10) {
            digitCount = 1;
        } else {
            while (number > 0) {
                digitCount += 1;
                number /= 10;
            }
        }

        return  digitCount;
    }

    public static int reverse (int number) {
        int sign = number < 0 ? -1 : 1;
        number = Math.abs(number);

       int reversedNumber = 0;
        while (number > 9) {
            int newDigit =  number % 10;
            reversedNumber = (reversedNumber + newDigit) * 10;
            number /= 10;
        }

        reversedNumber = sign * (reversedNumber + number);
        return reversedNumber;
    }

    public static String numberToWords(int number) {
        StringBuilder words = new StringBuilder();
        int numberOfDigits = getDigitCount(number);
        if (numberOfDigits < 0) return "Invalid Value";

        number = reverse(number);
        for (int i = 0; i < numberOfDigits; i++) {
            int trailingDigit = number % 10;
            words.append(digitsToWords(trailingDigit)).append(" ");
            number = number / 10;
        }

        words = new StringBuilder(words.substring(0, words.length() - 1));
        return words.toString();
    }
}
