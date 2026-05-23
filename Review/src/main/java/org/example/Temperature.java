package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Stores a Celsius temperature, provides conversion to Kelvin and Fahrenheit.
 * @author Eric Ricketts
 * @version 1.0-SNAPSHOT
 */
public class Temperature {
    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
            new BigDecimal("9.00").divide(new BigDecimal("5.00"), RoundingMode.HALF_UP);

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = BigDecimal.valueOf(32);

    private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = BigDecimal.valueOf(273.15);

    private BigDecimal celsius = BigDecimal.valueOf(0.00);

    public static final String TEMPERATURE_VALUE_TOO_LOW =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    public static final String NULL_VALUE_NOT_ALLOWED =
            "Null value is not allowed for a temperature entry";

    public static final String SCALE_FACTOR_VALUE_NEGATIVE =
            "Negative value is not allowed for scale factor";

    public static final String SCALE_FACTOR_VALUE_TOO_LARGE =
            "Scale factor is too large, keep to four decimals or less";

    private final int scaleFactor;

    public BigDecimal convertToFahrenheit() {
            BigDecimal rawConversion =
            this.getCelsius().multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER).add(CONVERSION_TO_FAHRENHEIT_ADDEND);

            return NumberUtils.setScale(rawConversion, scaleFactor);
    }

    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius().add(CONVERSION_TO_KELVIN_ADDEND);
        return NumberUtils.setScale(rawConversion, getScaleFactor());
    }

    /**
     * a referenced constructor in a constructor chaining
     * scale factor is checked for negative values, and for excessive accuracy
     * temperature value is checked for null values and below absolute zero
     * @param celsius stored temperature
     * @param scaling stored scaling value
     */
    public Temperature(BigDecimal celsius, int scaling) {
        scaleFactor = this.validateScaleFactor(scaling);
        BigDecimal validTemperature = this.validateCelsius(celsius);
        this.celsius = NumberUtils.setScale(
                validTemperature,
                scaleFactor
        );
    }

    public Temperature(BigDecimal celsius) {
        this(celsius, 2);
    }

    public Temperature() {
        this(BigDecimal.valueOf(0.00), 2);
    }

    public BigDecimal getCelsius() {
        return celsius;
    }

    public void setCelsius(BigDecimal celsius) {
        this.celsius = this.scaleValidatedCelsius(celsius);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Celsius temperature is first checked for null value and then checked if it is under absolute zero
     * @param celsius - proposed temperature for the object
     * @return a valid temperature, if the temperature is invalid, an exception is thrown
     */
    private BigDecimal validateCelsius(BigDecimal celsius) {
        if (Objects.isNull(celsius)) {
            throw new NullPointerException(NULL_VALUE_NOT_ALLOWED);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(BigDecimal.valueOf(0.00)) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_TOO_LOW);
        } else {
            return celsius;
        }
    }

    /**
     * input temperature is first validated and then returned after applying the object's scale factor
     * @param celsius - Celsius temperature to be validated and scaled
     * @return Validated temperature with scaling
     */
    private BigDecimal scaleValidatedCelsius(BigDecimal celsius) {
        return NumberUtils.setScale(
                this.validateCelsius(celsius),
                scaleFactor
        );
    }

    /**
     * checks that the scale factor is not negative and within the accuracy bounds
     * @param scaleFactor - proposed decimal accuracy for the object
     * @return validated decimal accuracy for use by the object
     */
    private int validateScaleFactor(int scaleFactor) {
        if (scaleFactor < 0) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_NEGATIVE);
        } else if (scaleFactor > 4) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_TOO_LARGE);
        } else {
            return scaleFactor;
        }
    }
}