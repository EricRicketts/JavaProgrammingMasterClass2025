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

    public static String getQuarter(String month) {
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String response = "Invalid month";
                yield response + " try again.";
                // in the case were we put "return" in front of the switch keyword
                // we cannot have any return keywords in the body of the switch statement
                // instead we use the yield keyword for blocks of code.
            }
        };
    }
}
