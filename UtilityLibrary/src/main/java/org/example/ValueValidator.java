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

    public static String checkForEmptyValueAndReturn(String value, String message) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static String validateNameAndReturn(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessages.EMPTY_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ErrorMessages.BLANK_VALUE_MESSAGE_FOR_NAME.getErrorMessage()
            );
        } else {
            return name;
        }
    }

    public static int validateIDAndReturn(int id) {
        if (id == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_ID.getErrorMessage()
            );
        } else if (id < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_ID.getErrorMessage()
            );
        } else {
            return id;
        }
    }

    public static BigDecimal validateGPAAndReturn(BigDecimal gpa) {
        if (Objects.isNull(gpa)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else if (gpa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_GPA.getErrorMessage()
            );
        } else {
            return gpa;
        }
    }

}