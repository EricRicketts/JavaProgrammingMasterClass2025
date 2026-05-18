package org.example;

import java.math.BigDecimal;

public class Temperature {

    private final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER = BigDecimal.valueOf(9.00/5.00);

    private final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal currentTemperature = BigDecimal.valueOf(0.00);

    private final int scaleFactor;

    public final static String TEMPERATURE_VIOLATION =
            "Entered Fahrenheit temperature is below absolute zero in Kelvin";

    public BigDecimal convertToFahrenheit() {
        if (this.convertToKelvin().compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            BigDecimal rawConversion =
                    this.getCurrentTemperature().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCurrentTemperature().add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, getScaleFactor());
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

    private int getScaleFactor() {
        return scaleFactor;
    }

    public BigDecimal getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(BigDecimal currentTemperature) {
        this.currentTemperature = this.checkForValidTemperatureAndScale(currentTemperature);
    }

    private BigDecimal checkForValidTemperature(BigDecimal C) {
        BigDecimal kelvinConversion = C.add(CONVERSION_TO_KELVIN_ADDEND);
        if (kelvinConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VIOLATION);
        } else {
            return C;
        }
    }

    private BigDecimal checkForValidTemperatureAndScale(BigDecimal C) {
        return NumberUtils.setScale(
                this.checkForValidTemperature(C),
                scaleFactor
        );
    }
}