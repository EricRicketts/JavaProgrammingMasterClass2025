package org.example;

public final class ErrorMessages {

    private ErrorMessages() {}

    public static String nullValue(String field) {
        return "Null value is not allowed for " + field;
    }

    public static String emptyValue(String field) {
        return "Empty value is not allowed for " + field;
    }

    public static String blankValue(String field) {
        return "Blank value is not allowed for " + field;
    }

    public static String zeroValue(String field) {
        return "Zero value is not allowed for " + field;
    }

    public static String negativeValue(String field) {
        return "Negative value is not allowed for " + field;
    }
}
