package org.example;

import java.math.BigDecimal;

public class Conversion {

    private static double conversionFactorForCentimeters = 2.54;
    private static int conversionFactorInches = 12;

    public static double convertToCentimeters(int inches) {
        double centimeters = inches * conversionFactorForCentimeters;
        BigDecimal centimetersToTwoDecimals =
                new BigDecimal(centimeters).setScale(2, BigDecimal.ROUND_HALF_UP);
        return centimetersToTwoDecimals.doubleValue();
    }

    public static double convertToCentimeters(int feet, int inches) {
        return convertToCentimeters(feet * conversionFactorInches + inches);
    }
}
