package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class ValueValidator {

    public static int checkForZeroValueAndReturn(int number, String message) {
        if (number == 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static BigDecimal checkForZeroValueAndReturn(BigDecimal number, String message) {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static int checkForNegativeValueAndReturn(int number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static BigDecimal checkForNegativeValueAndReturn(BigDecimal number, String message) {
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static <T> T checkForNullValueAndReturn(T value, String message) {
        return Objects.requireNonNull(value, message);
    }

    public static String checkForBlankValueAndReturn(String value, String message) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}