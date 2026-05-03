package org.example;

public enum ErrorMessage {

    NULL_VALUE_MESSAGE_FOR_NAME("Null value is not allowed for name"),

    BLANK_VALUE_MESSAGE_FOR_NAME("Blank value is not allowed for name"),

    ZERO_VALUE_MESSAGE_FOR_ID("Zero value is not allowed for id"),

    NEGATIVE_VALUE_MESSAGE_FOR_ID("Negative value is not allowed for id");
    private final String errorMessage;


    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
