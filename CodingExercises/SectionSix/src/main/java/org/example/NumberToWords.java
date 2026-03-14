package org.example;

public class NumberToWords {
/*
    123
    3
    3 * 10 + 2 = 30 + 2 = 32
    32 * 10 + 1 = 320 + 1 = 321
 */
    public static int reverse(int number) {
        int sign = 1;
        if (number < 0) {
            sign = -1;
        }
        number = Math.abs(number);
        int reversedNumber = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            reversedNumber =  (reversedNumber * 10) + currentDigit;
            number = number / 10;
        }
        return sign * reversedNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;
        if (number == 0) return 1;
       int digitCount = 0;
        while (number > 0) {
            number = number / 10;
            digitCount++;
        }
        return digitCount;
    }
    public static String numberToWords(int number) {
        StringBuilder numberToWords = new StringBuilder("");
        int digitCountNumber = getDigitCount(number);
        if (digitCountNumber < 0) return "Invalid Value";
        int reversedNumber = reverse(number);
        int digitCountReversedNumber = getDigitCount(reversedNumber);
        int numberOfTrailingZeros = digitCountNumber - digitCountReversedNumber;
        while (reversedNumber > 0) {
            int currentDigit = reversedNumber % 10;
            switch (currentDigit) {
                case 0 -> { numberToWords.append("Zero" + " "); }
                case 1 -> { numberToWords.append("One" + " "); }
                case 2 -> { numberToWords.append("Two" + " "); }
                case 3 -> { numberToWords.append("Three" + " "); }
                case 4 -> { numberToWords.append("Four" + " "); }
                case 5 -> { numberToWords.append("Five" + " "); }
                case 6 -> { numberToWords.append("Six" + " "); }
                case 7 -> { numberToWords.append("Seven" + " "); }
                case 8 -> { numberToWords.append("Eight" + " "); }
                case 9 -> { numberToWords.append("Nine" + " "); }
            }
            reversedNumber = reversedNumber / 10;
        }
        for (int j = 0; j < numberOfTrailingZeros; j++) {
            numberToWords.append("Zero" + " ");
        }
       return numberToWords.toString().trim();
    }
}
