package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Temperature {

    private final static int CONVERSION_TO_CELSIUS_SUBTRAHEND = 32;

    private final static double CONVERSION_TO_CELSIUS_DIVISOR = (double) 9/5;

    private final static double CONVERSION_TO_KELVIN_ADDEND = 459.67;

    private final static double CONVERSION_TO_KELVIN_MULTIPLIER = (double) 5/9;

    public static double convertToCelsius(double F, int scaleFactor) {
        BigDecimal rawConversion = BigDecimal.valueOf(
                (F - CONVERSION_TO_CELSIUS_SUBTRAHEND) / CONVERSION_TO_CELSIUS_DIVISOR
        );
        return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
    }

    public static double convertToKelvin(double F, int scaleFactor) {
        BigDecimal rawConversion = BigDecimal.valueOf(
                (F + CONVERSION_TO_KELVIN_ADDEND) * CONVERSION_TO_KELVIN_MULTIPLIER
        );
        return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
    };
}
