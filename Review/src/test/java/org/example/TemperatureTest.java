package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    @DisplayName("set up temperature object for tests")
    public void setUp() {
        temperature = new Temperature(new BigDecimal("12.34"), 2);
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
    @DisplayName("test convert Celsius to Fahrenheit")
    class TestConvertCelsiusToFahrenheit {

        @ParameterizedTest
        @CsvSource(
            {
                "54.34, 1, 129.7",
                "54.35, 1, 129.9",
                "25.73, 2, 78.31",
                "-47.56, 2, -53.61",
                "25.733, 3, 78.319",
                "-47.561, 3, -53.610",
                "25.7334, 4, 78.3201",
                "-47.5612, 4, -53.6102"
            }
        )

        public void testConvertCelsiusToFahrenheitAllScaleFactors(
            String temperatureValue, int scaleFactor, String expected
        ) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(expected),
                temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test convert Celsius to Kelvin")
    class TestConvertCelsiusToKelvin {

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
    class TestAbsoluteZeroBoundary {

        @Test
        public void testAbsoluteZeroForSetterAndConstructor() {
            assertAll("Absolute zero is a valid temperature",
                () -> {
                    temperature.setCelsius(new BigDecimal("-273.15"));
                    assertEquals(new BigDecimal("-273.15"), temperature.getCelsius());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("-273.15"), 2);
                    assertEquals(new BigDecimal("-273.15"), temperature.getCelsius());
                }
            );
        }

        @Test
        public void testBelowAbsoluteZeroForSetterAndConstructor() {
            assertAll("Under absolute zero is not allowed",
                () -> assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                        IllegalArgumentException.class,
                        () -> temperature.setCelsius(new BigDecimal("-273.16"))
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
                    assertThrows(
                        IllegalArgumentException.class,
                        () -> new Temperature(new BigDecimal("-273.16"), 2)
                    ).getMessage()
                )
            );
        }
    }

    @Nested
    @DisplayName("zero, one and two argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testAllConstructors() {
            assertAll("all constructor variations tested for valid object creation",
                () -> {
                    temperature = new Temperature();
                    assertEquals(new BigDecimal("0.00"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("98.76"));
                    assertEquals(new BigDecimal("98.76"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("67.89"), 2);
                    assertEquals(new BigDecimal("67.89"), temperature.getCelsius());
                    assertEquals(2, temperature.getScaleFactor());
                }
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        static Stream<Arguments> invalidScaleFactorProvider() {
            return Stream.of(
                arguments("23.45", -2, Temperature.SCALE_FACTOR_VALUE_NEGATIVE),
                arguments("23.45", 5, Temperature.SCALE_FACTOR_VALUE_TOO_LARGE)
            );
        }

        @ParameterizedTest
        @CsvSource({"87.65, 0, 88", "87.45, 0, 87", "87.65, 1, 87.7", "87.64, 1, 87.6"})
        public void testScaleFactorsZeroAndOne (String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @CsvSource({"34.455, 2, 34.46", "34.454, 2, 34.45", "87.7475, 3, 87.748", "87.7474, 3, 87.747"})
        public void testScaleFactorsTwoAndThree (String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @CsvSource({"12.34565, 4, 12.3457", "12.34564, 4, 12.3456"})
        public void testScaleFactorFour(String temperatureValue, int scaleFactor, String result) {
            temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);
            assertEquals(
                new BigDecimal(result),
                temperature.getCelsius()
            );
        }

        @ParameterizedTest
        @MethodSource("invalidScaleFactorProvider")
        public void testScaleFactorsNegativeAndTooLarge(String temperatureValue, int scaleFactor, String expected) {
            assertEquals(
                expected,
                assertThrows(
                    IllegalArgumentException.class,
                    () -> new Temperature(new BigDecimal(temperatureValue), scaleFactor)
                ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPoints {

        @Test
        public void testFreezingAndBoilingPoints() {
            assertAll("Freezing and boiling points in Fahrenheit and Kelvin",
                () -> {
                    temperature = new Temperature(new BigDecimal("0.00"), 2);
                    assertEquals(new BigDecimal("32.00"), temperature.convertToFahrenheit());
                    assertEquals(new BigDecimal("273.15"), temperature.convertToKelvin());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("100.00"), 2);
                    assertEquals(new BigDecimal("212.00"), temperature.convertToFahrenheit());
                    assertEquals(new BigDecimal("373.15"), temperature.convertToKelvin());
                },
                () -> {
                    temperature = new Temperature(new BigDecimal("-40.00"), 2);
                    assertEquals(new BigDecimal("-40.00"), temperature.convertToFahrenheit());
                }
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValuesInSettersAndOneAndTwoArgumentConstructors() {
            assertAll("Null values not allowed in setters and constructors",
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> temperature.setCelsius(null)
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> new Temperature(null)
                    ).getMessage()
                ),
                () -> assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                        NullPointerException.class,
                        () -> new Temperature(null, 2)
                    ).getMessage()
                )
            );
        }
    }
}