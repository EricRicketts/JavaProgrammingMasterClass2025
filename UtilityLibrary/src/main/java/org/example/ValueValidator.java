package org.example;

import java.util.Objects;

public class ValueValidator {

    public static int checkForNegativeValue(int number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static double checkForNegativeValue(double number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static <T> T checkForNull(T value, String message) {
        return Objects.requireNonNull(value, message);
    }

}
