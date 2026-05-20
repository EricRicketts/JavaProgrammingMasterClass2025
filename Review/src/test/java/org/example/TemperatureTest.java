package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    @DisplayName("set up temperature object for tests")
    public void setUp() {
        temperature = new Temperature(BigDecimal.valueOf(12.34), 2);
    }

    @Nested
    @DisplayName("test getters and setters")
    class TestTemperatureGettersAndSetters {

        @Test
        public void testTemperatureGetter() {
            assertEquals(
                    new BigDecimal("12.34"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCelsius(new BigDecimal("45.67"));
            assertEquals(
                    new BigDecimal("45.67"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testScaleFactorGetter() {
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Fahrenheit")
    class TestConvertValidTemperaturesCelsiusToFahrenheit {

        @Test
        public void testConvertPositiveCelsiusToFahrenheitRoundDown() {
            assertEquals(
                    new BigDecimal("78.31"),
                    new Temperature(new BigDecimal("25.73"), 2).convertToFahrenheit()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToFahrenheitRoundUp() {
            assertEquals(
                    new BigDecimal("-53.61"),
                    new Temperature(new BigDecimal("-47.56"), 2).convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Kelvin")
    class TestConvertValidTemperaturesCelsiusToKelvin {

        @Test
        public void testConvertPositiveCelsiusToKelvin() {
            assertEquals(
                    new BigDecimal("285.49"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCelsius(new BigDecimal("-123.45"));
            assertEquals(
                    new BigDecimal("149.70"),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Celsius")
    class TestAbsoluteZeroBoundaryForCelsius {

        @Test
        public void testSetAbsoluteZeroForCelsius() {
            temperature.setCelsius(new BigDecimal("-273.15"));
            assertEquals(
                    new BigDecimal("-273.15"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSetLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> temperature.setCelsius(new BigDecimal("-273.16"))
                    ).getMessage()
            );
        }

        @Test
        public void testInitializeAbsoluteZeroForCelsius() {
            Temperature temperature = new Temperature(new BigDecimal("-273.15"), 2);
            assertEquals(
                    new BigDecimal("-273.15"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testInitializeLessThanAbsoluteZeroForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VALUE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("-273.16"), 2)
                    ).getMessage()
            );
        }

        @Test
        public void testSetAbsoluteZeroForFahrenheit() {
            temperature.setCelsius(new BigDecimal("-273.15"));
            assertEquals(
                    new BigDecimal("-459.67"),
                    temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("zero and one argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testNoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature();
            assertEquals(
                new BigDecimal("100.13"),
                temperature.getCelsius()
            );
        }

        @Test
        public void testSingleArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(new BigDecimal("98.76"));
            assertEquals(
                    new BigDecimal("98.76"),
                    temperature.getCelsius()
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        @Test
        public void testSingleDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("87.65"), 1);
            assertEquals(
                    new BigDecimal("87.7"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testSingleDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("87.64"), 1);
            assertEquals(
                    new BigDecimal("87.6"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundUp() {
            Temperature temperature = new Temperature(new BigDecimal("87.7475"), 3);
            assertEquals(
                    new BigDecimal("87.748"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testThreeDigitScaleFactorRoundDown() {
            Temperature temperature = new Temperature(new BigDecimal("87.7474"), 3);
            assertEquals(
                    new BigDecimal("87.747"),
                    temperature.getCelsius()
            );
        }

        @Test
        public void testNegativeScaleFactor() {
            assertEquals(
                    Temperature.NEGATIVE_VALUE_SCALE_FACTOR_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), -2)
                    ).getMessage()
            );
        }

        @Test
        public void testExcessiveScaleFactorPrecision() {
            assertEquals(
                    Temperature.SCALE_FACTOR_VALUE_TOO_LARGE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), 5)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPointsForAllTemperatureScales {

        @Test
        public void testFreezingPoint() {
            Temperature temperature = new Temperature(new BigDecimal("0.00"), 2);
            assertEquals(
                    new BigDecimal("32.00"),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    new BigDecimal("273.15"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testBoilingPoint() {
            Temperature temperature = new Temperature(new BigDecimal("100.00"), 2);
            assertEquals(
                    new BigDecimal("212.00"),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    new BigDecimal("373.15"),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testTheOneSharedTemperatureBetweenCelsiusAndFahrenheit() {
            Temperature temperature = new Temperature(new BigDecimal("-40.00"), 2);
            assertEquals(
                    new BigDecimal("-40.00"),
                    temperature.convertToFahrenheit()
            );
            assertEquals(
                    new BigDecimal("233.15"),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValueInSetter() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> temperature.setCelsius(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInSingleArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInTwoArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_VIOLATION,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null, 2)
                    ).getMessage()
            );
        }
    }
}