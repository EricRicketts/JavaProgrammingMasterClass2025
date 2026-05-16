package org.example;

import java.math.BigDecimal;

public class Temperature {

    private final static double CONVERSION_TO_FAHRENHEIT_MULTIPLIER = 9.00/5.00;

    private final static double CONVERSION_TO_FAHRENHEIT_ADDEND = 32;

    private final static double CONVERSION_TO_KELVIN_ADDEND = 273.15;

    private double currentTemperature = 0.00;

    public final static String TEMPERATURE_VIOLATION =
            "Entered Fahrenheit temperature is below absolute zero in Kelvin";

    public static double convertToFahrenheit(double C, int scaleFactor) {
        if (Temperature.convertToKelvin(C, scaleFactor) < 0.00) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            BigDecimal rawConversion = BigDecimal.valueOf(
                    (C * CONVERSION_TO_FAHRENHEIT_MULTIPLIER) + CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
        }
    }

    public static double convertToKelvin(double C, int scaleFactor) {
        BigDecimal rawConversion = BigDecimal.valueOf(
                (C + CONVERSION_TO_KELVIN_ADDEND)
        );
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, scaleFactor).doubleValue();
        }
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}
