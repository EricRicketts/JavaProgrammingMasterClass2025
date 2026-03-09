package org.example;

import java.math.BigDecimal;

public class Conversion {

    private static final double conversionFactorForCentimeters = 2.54;
    private static final int conversionFactorInches = 12;
    private static final int conversionFactorForHours = 3600;
    private static final int conversionFactorForMinutes = 60;

    public static double convertToCentimeters(int inches) {
        double centimeters = inches * conversionFactorForCentimeters;
        BigDecimal centimetersToTwoDecimals =
                new BigDecimal(centimeters).setScale(2, BigDecimal.ROUND_HALF_UP);
        return centimetersToTwoDecimals.doubleValue();
    }

    public static double convertToCentimeters(int feet, int inches) {
        return convertToCentimeters(feet * conversionFactorInches + inches);
    }

    public static String getDurationString(int seconds) {
        // XXh YYm ZZs
        String message = "Invalid entry seconds must be positive.";
       if (seconds < 0) return message;
       // Integer division gives the number of hours, and integer modulo gives the remaining number of seconds.
       // It is the remaining number of seconds because 1 hour = 3600 seconds.
       int numberOfHours = seconds / conversionFactorForHours;
       int secondsRemaining = seconds % conversionFactorForHours;
       // We take the remaining seconds and use integer division to get the number of minutes.
       // We take the remaining seconds and use integer modulo to get the left-over seconds.
       // This works because 1 minute = 60 seconds
       int numberOfMinutes = secondsRemaining / conversionFactorForMinutes;
       int numberOfSeconds = secondsRemaining % conversionFactorForMinutes;
       message = numberOfHours + "h " + numberOfMinutes + "m " + numberOfSeconds + "s";
       return message;
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) return "Invalid entry minutes must be positive.";
        if (seconds < 0 || seconds > 59) return "Invalid entry seconds must be between 0 and 59.";
        int numberOfSeconds = minutes * conversionFactorForMinutes + seconds;
        return getDurationString(numberOfSeconds);
    }
}
