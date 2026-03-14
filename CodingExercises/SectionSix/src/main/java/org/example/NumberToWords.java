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
        int numberOfTrailingZeros = getNumberOfTrailingZeros(digitCountNumber, reversedNumber);

        numberToWords = convertReversedNumberToWords(numberToWords, reversedNumber);
        numberToWords = appendTrailingZeros(numberToWords, numberOfTrailingZeros);
        return numberToWords.toString().trim();
    }

    private static int getNumberOfTrailingZeros(int digitCountNumber, int reversedNumber) {
        int digitCountReversedNumber = getDigitCount(reversedNumber);
        return digitCountNumber - digitCountReversedNumber;
    }
    private static StringBuilder convertReversedNumberToWords
            (StringBuilder numberToWords, int reversedNumber) {
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
        return numberToWords;
    }
    private static StringBuilder appendTrailingZeros(
            StringBuilder stringBuilder, int numberOfTrailingZeros) {
        for (int i = 0; i < numberOfTrailingZeros; i++) {
            stringBuilder.append("Zero" + " ");
        }
        return stringBuilder;
    }
}
