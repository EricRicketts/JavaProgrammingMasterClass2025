package org.example;

import java.math.BigDecimal;

public class Temperature {

    private final static int CONVERSION_TO_CELSIUS_SUBTRAHEND = 32;

    private final static double CONVERSION_TO_CELSIUS_DIVISOR = (double) 9/5;

    private final static double CONVERSION_TO_KELVIN_ADDEND = 459.67;

    private final static double CONVERSION_TO_KELVIN_MULTIPLIER = (double) 5/9;

    public final static String TEMPERATURE_VIOLATION =
            "Entered Fahrenheit temperature is below absolute zero in Kelvin";

    public static double convertToCelsius(double F, int scaleFactor) {
        if (Temperature.convertToKelvin(F, scaleFactor) < 0.00) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            BigDecimal rawConversion = BigDecimal.valueOf(
                    (F - CONVERSION_TO_CELSIUS_SUBTRAHEND) / CONVERSION_TO_CELSIUS_DIVISOR
            );
            return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
        }
    }

    public static double convertToKelvin(double F, int scaleFactor) {
        BigDecimal rawConversion = BigDecimal.valueOf(
                (F + CONVERSION_TO_KELVIN_ADDEND) * CONVERSION_TO_KELVIN_MULTIPLIER
        );
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
        }
    }
}
