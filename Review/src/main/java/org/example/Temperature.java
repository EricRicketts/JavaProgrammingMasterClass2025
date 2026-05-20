package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Temperature {

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
            BigDecimal.valueOf(9.00).divide(BigDecimal.valueOf(5.00), RoundingMode.HALF_UP);

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal celsius = BigDecimal.valueOf(0.00);

    private final int scaleFactor;

    public final static String TEMPERATURE_VALUE_VIOLATION =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    public final static String NULL_VALUE_VIOLATION =
            "Null value is not allowed for a temperature entry";

    public BigDecimal convertToFahrenheit() {
        if (this.convertToKelvin().compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
        } else {
            BigDecimal rawConversion =
                    this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
                            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);
            return NumberUtils.setScale(rawConversion, scaleFactor);
        }
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius().add(CONVERSION_TO_KELVIN_ADDEND);
        if (rawConversion.compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
        } else {
            return NumberUtils.setScale(rawConversion, getScaleFactor());
        }
    }

    public Temperature(BigDecimal celsius, int scaling) {
        scaleFactor = scaling;
        BigDecimal validTemperature = this.validateCelsiusTemperature(celsius);
        this.celsius = NumberUtils.setScale(
                validTemperature,
                scaleFactor
        );
    }

    public Temperature(BigDecimal celsius) {
        this(celsius, 2);
    }

    public Temperature() {
        this(BigDecimal.valueOf(100.13), 2);
    }

    public BigDecimal getCelsius() {
        return celsius;
    }

    public void setCelsius(BigDecimal celsius) {
        this.celsius = this.validateCelsiusTemperatureAndScale(celsius);
    }
    public int getScaleFactor() {
        return scaleFactor;
    }

    private BigDecimal validateCelsiusTemperature(BigDecimal celsius) {
        if (Objects.isNull(celsius)) {
            throw new NullPointerException(NULL_VALUE_VIOLATION);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_VIOLATION);
        } else {
            return celsius;
        }
    }

    private BigDecimal validateCelsiusTemperatureAndScale(BigDecimal celsius) {
        return NumberUtils.setScale(
                this.validateCelsiusTemperature(celsius),
                scaleFactor
        );
    }
}