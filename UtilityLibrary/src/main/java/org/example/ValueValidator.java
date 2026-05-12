package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class ValueValidator {

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
}