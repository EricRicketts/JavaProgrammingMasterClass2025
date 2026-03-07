package org.example;

public class PositiveNegativeZero {

    public static String checkNumber(int number) {
        String message = "zero";
        if (number > 0) {
            message = "positive";
        } else if (number < 0) {
            message = "negative";
        }
        return message;
    }
}
