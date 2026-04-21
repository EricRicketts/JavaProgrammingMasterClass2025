package org.example;

public enum ErrorMessages {

    NULL_VALUE_MESSAGE_FOR_LENGTH("Null value is not allowed for length"),
    NEGATIVE_VALUE_MESSAGE_FOR_LENGTH("Negative value is not allowed for length"),
    NULL_VALUE_MESSAGE_FOR_WIDTH("Null value is not allowed for width"),
    NEGATIVE_VALUE_MESSAGE_FOR_WIDTH("Negative value is not allowed for width"),
    NULL_VALUE_MESSAGE_FOR_SIDE("Null value is not allowed for a side"),
    NEGATIVE_VALUE_MESSAGE_FOR_SIDE("Negative value is not allowed for a side");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
