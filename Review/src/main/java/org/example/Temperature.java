package org.example;

import java.math.BigDecimal;

public class Temperature {

    private final static BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER = BigDecimal.valueOf(9.00/5.00);

    private final static BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private final static BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal currentTemperature = BigDecimal.valueOf(0.00);

    private final static int scaleFactor;

    public final static String TEMPERATURE_VIOLATION =
            "Entered Fahrenheit temperature is below absolute zero in Kelvin";

    public static BigDecimal convertToFahrenheit(BigDecimal C) {
        if (Temperature.convertToKelvin(C).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            BigDecimal rawConversion =
                    C.multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public static BigDecimal convertToKelvin(BigDecimal C) {
        BigDecimal rawConversion = C.add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public Temperature(BigDecimal C, int scaling) {
        scaleFactor = scaling;
        BigDecimal validTemperature = this.checkForValidTemperature(C);
        this.currentTemperature = NumberUtils.setScale(
                validTemperature,
                scaleFactor
        );
    }

    public Temperature(BigDecimal C) {
        this(C, 2);
    }

    public Temperature() {
        this(BigDecimal.valueOf(100.00), 2);
    }

    public BigDecimal getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(BigDecimal currentTemperature) {
        this.currentTemperature = this.checkForValidTemperatureAndScale(currentTemperature);
    }

    private BigDecimal checkForValidTemperature(BigDecimal C) {
        BigDecimal rawConversion = C.add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return rawConversion;
        }
    }

    private BigDecimal checkForValidTemperatureAndScale(BigDecimal C) {
        return NumberUtils.setScale(
                this.checkForValidTemperature(C),
                scaleFactor
        );
    }
}
