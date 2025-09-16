package org.example;

public class EnhancedSwitchStatement {

    public static String chooseValues(int value) {
        String result = "";
        String secondResult = "";
        switch (value) {
            case 1 -> result = "The value was 1.";
            case 2 -> result = "The value was 2.";
            case 3, 4, 5 -> {
                result = "The value was a 3, a 4, or a 5.";
                secondResult = "The exact value was " + value + ".";
            }
            default -> result = "The value was not 1, 2, 3, 4 or 5.";
        }
        if (secondResult.isBlank()) { return result; }
        return result + "  " + secondResult;
    }
}
