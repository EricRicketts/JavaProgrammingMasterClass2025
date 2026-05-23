package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Represents a temperature stored in degrees Celsius.
 *
 * <p>The temperature can be converted to Fahrenheit or Kelvin. Values below
 * absolute zero are not allowed. Temperature values and conversion results are
 * rounded using the object's scale factor.</p>
 *
 * @author Eric Ricketts
 * @version 1.0-SNAPSHOT
 */
public class Temperature {
    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_MULTIPLIER =
            new BigDecimal("9.00").divide(new BigDecimal("5.00"), RoundingMode.HALF_UP);

    private static final BigDecimal CONVERSION_TO_FAHRENHEIT_ADDEND = new BigDecimal("32");

    private static final BigDecimal CONVERSION_TO_KELVIN_ADDEND = new BigDecimal("273.15");

    private static final BigDecimal ZERO = new BigDecimal("0.00");

    private static final int MAX_SCALE_FACTOR = 4;

    private static final int DEFAULT_SCALE_FACTOR = 2;

    private static final String TEMPERATURE_VALUE_TOO_LOW =
            "Upon conversion to Kelvin, entered temperature is below absolute zero.";

    private static final String NULL_VALUE_NOT_ALLOWED =
            "Null value is not allowed for a temperature entry";

    private static final String SCALE_FACTOR_VALUE_NEGATIVE =
            "Negative value is not allowed for scale factor";

    private static final String SCALE_FACTOR_VALUE_TOO_LARGE =
            "Scale factor is too large, keep to four decimals or less";

    private BigDecimal celsius = ZERO;

    private final int scaleFactor;

    /**
     * Converts the stored Celsius temperature to Fahrenheit.
     *
     * @return the Fahrenheit equivalent of the stored Celsius temperature, rounded
     *         using this object's scale factor
     */
    public BigDecimal convertToFahrenheit() {
        BigDecimal rawConversion = this.getCelsius()
            .multiply(CONVERSION_TO_FAHRENHEIT_MULTIPLIER)
            .add(CONVERSION_TO_FAHRENHEIT_ADDEND);

        return NumberUtils.setScale(rawConversion, scaleFactor);
    }

    /**
     * Converts the stored Celsius temperature to Kelvin.
     *
     * @return the Kelvin equivalent of the stored Celsius temperature, rounded
     *         using this object's scale factor
     */
    public BigDecimal convertToKelvin() {
        BigDecimal rawConversion = this.getCelsius()
            .add(CONVERSION_TO_KELVIN_ADDEND);

        return NumberUtils.setScale(rawConversion, getScaleFactor());
    }

    /**
     * Creates a temperature with the specified Celsius value and scale factor.
     *
     * <p>The Celsius value is rounded using the provided scale factor. The scale
     * factor determines the number of decimal places used for stored values and
     * conversion results.</p>
     *
     * @param celsius the initial Celsius temperature
     * @param scaleFactor the number of decimal places to use when rounding
     * @throws IllegalArgumentException if {@code celsius} is null, below absolute
     *         zero, or if {@code scaleFactor} is negative or greater than the maximum
     *         allowed scale
     */
    public Temperature(BigDecimal celsius, int scaleFactor) {
        this.scaleFactor = this.validateScaleFactor(scaleFactor);
        BigDecimal validTemperature = this.validateCelsius(celsius);

        this.celsius = NumberUtils.setScale(
            validTemperature,
            this.scaleFactor
        );
    }

    /**
     * Creates a temperature with the specified Celsius value and a default scale
     * factor of 2.
     *
     * @param celsius the initial Celsius temperature
     * @throws IllegalArgumentException if {@code celsius} is null or below absolute zero
     */
    public Temperature(BigDecimal celsius) {
        this(celsius, DEFAULT_SCALE_FACTOR);
    }

    /**
     * Creates a temperature of 0.00 degrees Celsius with a default scale factor of 2.
     */
    public Temperature() {
        this(ZERO, DEFAULT_SCALE_FACTOR);
    }

    /**
     * Returns the stored Celsius temperature.
     *
     * @return the current Celsius temperature
     */
    public BigDecimal getCelsius() {
        return celsius;
    }

    /**
     * Sets the stored Celsius temperature.
     *
     * <p>The new value is rounded using this object's scale factor.</p>
     *
     * @param celsius the new Celsius temperature
     * @throws IllegalArgumentException if {@code celsius} is null or below absolute zero
     */
    public void setCelsius(BigDecimal celsius) {
        this.celsius = this.scaleValidatedCelsius(celsius);
    }

    /**
     * Returns the scale factor used for rounding stored values and conversion results.
     *
     * @return the number of decimal places used for rounding
     */
    public int getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Validates that a Celsius temperature is not null and is not below absolute zero.
     *
     * @param celsius the Celsius temperature to validate
     * @return the validated Celsius temperature
     * @throws IllegalArgumentException if {@code celsius} is null or below absolute zero
     */
    private BigDecimal validateCelsius(BigDecimal celsius) {
        if (Objects.isNull(celsius)) {
            throw new IllegalArgumentException(NULL_VALUE_NOT_ALLOWED);
        } else if (celsius.add(CONVERSION_TO_KELVIN_ADDEND).compareTo(ZERO) < 0) {
            throw new IllegalArgumentException(TEMPERATURE_VALUE_TOO_LOW);
        } else {
            return celsius;
        }
    }

    /**
     * Validates and rounds a Celsius temperature using this object's scale factor.
     *
     * @param celsius the Celsius temperature to validate and round
     * @return the validated and rounded Celsius temperature
     * @throws IllegalArgumentException if {@code celsius} is null or below absolute zero
     */
    private BigDecimal scaleValidatedCelsius(BigDecimal celsius) {
        return NumberUtils.setScale(
            this.validateCelsius(celsius),
            scaleFactor
        );
    }

    /**
     * Validates that a scale factor is within the allowed range.
     *
     * @param scaleFactor the scale factor to validate
     * @return the validated scale factor
     * @throws IllegalArgumentException if {@code scaleFactor} is negative or greater
     *         than the maximum allowed scale
     */
    private int validateScaleFactor(int scaleFactor) {
        if (scaleFactor < 0) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_NEGATIVE);
        } else if (scaleFactor > MAX_SCALE_FACTOR) {
            throw new IllegalArgumentException(SCALE_FACTOR_VALUE_TOO_LARGE);
        } else {
            return scaleFactor;
        }
    }
}