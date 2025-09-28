package org.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class NumberToWords {

    public static String digitsToWords(int number) {
        return switch(number) {
            case 0:
                yield "Zero";
            case 1:
                yield "One";
            case 2:
                yield "Two";
            case 3:
                yield "Three";
            case 4:
                yield "Four";
            case 5:
                yield "Five";
            case 6:
                yield "Six";
            case 7:
                yield "Seven";
            case 8:
                yield "Eight";
            case 9:
                yield "Nine";
            default:
                yield "Invalid number";
        };
    }
    Map<Integer, String> digitsToWords = Map.ofEntries(
            entry(0, "Zero"),
            entry(1, "One"),
            entry(2, "Two"),
            entry(3, "Three"),
            entry(4, "Four"),
            entry(5, "Five"),
            entry(6, "Six"),
            entry(7, "Seven"),
            entry(8, "Eight"),
            entry(9, "Nine")
    );
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
        String words = "";
        int numberOfDigits = getDigitCount(reverse(number)) >= 0 ?  getDigitCount(reverse(number)) : -1;
        if  (numberOfDigits == -1) return "Invalid Value";
        if (number < 10) return digitsToWords(number);

        number = reverse(number);
        while (number > 0) {
            int trailingDigit =  number % 10;
            words = words.concat(digitsToWords(trailingDigit) + " ");
            number /= 10;
        }

        words = words.substring(0, words.length() - 1);
        return words;
    }
}
