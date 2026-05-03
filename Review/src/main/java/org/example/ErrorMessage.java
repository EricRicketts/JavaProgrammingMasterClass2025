package org.example;

public enum ErrorMessage {

    NULL_VALUE_MESSAGE_FOR_NAME("Null value is not allowed for name"),

    BLANK_VALUE_MESSAGE_FOR_NAME("Blank value is not allowed for name"),

    NULL_VALUE_MESSAGE_FOR_CITY("Null value is not allowed for city"),

    BLANK_VALUE_MESSAGE_FOR_CITY("Blank value is not allowed for city"),

    ZERO_VALUE_MESSAGE_FOR_AGE("Zero value is not allowed for age"),

    NEGATIVE_VALUE_MESSAGE_FOR_AGE("Negative value is not allowed for age"),

    ZERO_VALUE_MESSAGE_FOR_ID("Zero value is not allowed for id"),

    NEGATIVE_VALUE_MESSAGE_FOR_ID("Negative value is not allowed for id"),

    ZERO_VALUE_MESSAGE_FOR_GPA("Zero value is not allowed for gpa"),

    NEGATIVE_VALUE_MESSAGE_FOR_GPA("Negative value is not allowed for gpa"),

    NULL_VALUE_MESSAGE_FOR_WIDTH("Null value is not allowed for width"),

    NEGATIVE_VALUE_MESSAGE_FOR_WIDTH("Negative value is not allowed for width"),

    NULL_VALUE_MESSAGE_FOR_HEIGHT("Null value is not allowed for height"),

    NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT("Negative value is not allowed for height"),

    ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR("Zero value is not allowed for scale factor"),

    NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR("Negative value is not allowed for scale factor"),

    NULL_VALUE_MESSAGE_FOR_SIDE("Null value is not allowed for side"),

    ZERO_VALUE_MESSAGE_FOR_SIDE("Zero value is not allowed for side"),

    NEGATIVE_VALUE_MESSAGE_FOR_SIDE("Negative value is not allowed for side");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
