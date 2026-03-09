package org.example;

import java.math.BigDecimal;

public class Conversion {

    private static final double conversionFactorForCentimeters = 2.54;
    private static final int conversionFactorInches = 12;
    private static final int conversionFactorForHours = 3600;
    private static final int conversionFactorForMinutesAndSeconds = 60;

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
       int numberOfHours = seconds / conversionFactorForHours;
       int minutesLeft = seconds % conversionFactorForHours;
       int numberOfMinutes = minutesLeft / conversionFactorForMinutesAndSeconds;
       int numberOfSeconds = minutesLeft % conversionFactorForMinutesAndSeconds;
       message = numberOfHours + "h " + numberOfMinutes + "m " + numberOfSeconds + "s";
       return message;
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) return "Invalid entry minutes must be positive.";
        if (seconds < 0 || seconds > 59) return "Invalid entry seconds must be between 0 and 59.";
        int numberOfSeconds = minutes * conversionFactorForMinutesAndSeconds + seconds;
        return getDurationString(numberOfSeconds);
    }
}
