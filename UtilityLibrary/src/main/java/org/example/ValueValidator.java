package org.example;

import java.math.BigDecimal;
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

    public static BigDecimal checkForNegativeValue(BigDecimal number, String message) {
        if (number.signum() < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static <T> T checkForNull(T value, String message) {
        return Objects.requireNonNull(value, message);
    }

    public static BigDecimal validateNumberAndReturn(
            BigDecimal number,
            int scaleFactor,
            String nullMessage,
            String negativeMessage
    ) {
        ValueValidator.checkForNull(number, nullMessage);
        ValueValidator.checkForNegativeValue(number, negativeMessage);
        return NumberUtils.setScale(number, scaleFactor);
    }
}
