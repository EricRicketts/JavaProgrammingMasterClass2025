package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class ValueValidator {

    public static int checkForNegativeOrZeroValue(int number, String message) {
        if (number <= 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }
    public static int checkForNegativeValue(int number, String message) {
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

    public static String checkForNullOrBlankString(
            String value,
            String nullMessage,
            String blankMessage
    ) {
        if (value == null) {
            throw new NullPointerException(nullMessage);
        } else if (value.isBlank()) {
            throw new IllegalArgumentException(blankMessage);
        }
        return value;
    }
    public static BigDecimal validateNumberAndReturn(
            BigDecimal number,
            String nullMessage,
            String negativeMessage
    ) {
        checkForNull(number, nullMessage);
        checkForNegativeValue(number, negativeMessage);
        return number;
    }
}
