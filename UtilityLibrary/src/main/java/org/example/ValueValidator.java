package org.example;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

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

    public static <T> T checkForNullValueAndReturn(T value, String message) {
        return Objects.requireNonNull(value, message);
    }

    public static String checkForBlankValueAndReturn(String value, String message) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static String checkForEmptyValueAndReturn(String value, String message) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static String validateTextAndReturn(String value, String fieldName) {
        if(Objects.isNull(value)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(fieldName)
            );
        } else if (value.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.emptyValue(fieldName)
            );
        } else if (value.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.blankValue(fieldName)
            );
        } else {
            return value;
        }
    }

    public static int validatePositiveIntAndReturn(int value, String fieldName) {
        if (value == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(fieldName)
            );
        } else if (value < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(fieldName)
            );
        } else {
            return value;
        }
    }

    public static BigDecimal validatePositiveBigDecimalAndReturn(BigDecimal value, String fieldName) {
        if (Objects.isNull(value)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(fieldName)
            );
        } else if (value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.zeroValue(fieldName)
            );
        } else if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(fieldName)
            );
        } else {
            return value;
        }
    }

    public static BigDecimal validateNonNegativeBigDecimalAndReturn(BigDecimal value, String fieldName) {
        if (Objects.isNull(value)) {
            throw new NullPointerException(
                    ErrorMessages.nullValue(fieldName)
            );
        } else if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.negativeValue(fieldName)
            );
        } else {
            return value;
        }
    }

    public static BigDecimal validateAndScalePositiveBigDecimal(
            BigDecimal value,
            int scaleFactor,
            String fieldName
    ) {
        BigDecimal validValue = validatePositiveBigDecimalAndReturn(value, fieldName);
        return NumberUtils.setScale(validValue, scaleFactor);
    }

    public static BigDecimal validateNonNegativeBalanceAfterWithdraw(BigDecimal newBalance, String message) {
        return ValueValidator.validateNonNegativeValueAndReturn(newBalance, message);
    }
}