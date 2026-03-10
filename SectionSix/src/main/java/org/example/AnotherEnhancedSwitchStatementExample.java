package org.example;

public class AnotherEnhancedSwitchStatementExample {

    public static String enhancedSwitchStatementExample(int value) {
        // the return on the outside of the switch expression is used to exit the method
        String message = "";
        return switch (value) {
            case 1 -> {
                message = "Value is 1";
                yield message;
            }
            case 2 -> {
                message = "Value is 2";
                yield message;
            }
            default -> {
                message = "Value is neither 1 or 2";
                yield message;
            }
        };
    }
}
