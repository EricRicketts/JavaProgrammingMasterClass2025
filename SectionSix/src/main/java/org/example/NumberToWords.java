package org.example;

public class NumberToWords {

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
        return 1;
    }

    public static String numberToWords(int number) {
        return "foo";
    }
}
