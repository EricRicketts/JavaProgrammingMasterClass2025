package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

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

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorOneRoundDown() {
            // scales to 54.3 for temperature object
            temperature = new Temperature(new BigDecimal("54.34"), 1);
            assertEquals(
                    new BigDecimal("129.7"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorOneRoundUp() {
            // scales to 54.4 for temperature object
            temperature = new Temperature(new BigDecimal("54.35"), 1);
            assertEquals(
                    new BigDecimal("129.9"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorTwoRoundDown() {
            temperature = new Temperature(new BigDecimal("25.73"), 2);
            assertEquals(
                    new BigDecimal("78.31"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorTwoRoundUp() {
            temperature = new Temperature(new BigDecimal("-47.56"), 2);
            assertEquals(
                    new BigDecimal("-53.61"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorThreeRoundDown() {
            temperature = new Temperature(new BigDecimal("25.733"), 3);
            assertEquals(
                    new BigDecimal("78.319"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorThreeRoundUp() {
            temperature = new Temperature(new BigDecimal("-47.561"), 3);
            assertEquals(
                    new BigDecimal("-53.610"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorFourRoundDown() {
            temperature = new Temperature(new BigDecimal("25.7334"), 4);
            assertEquals(
                    new BigDecimal("78.3201"),
                    temperature.convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitScaleFactorFourRoundUp() {
            temperature = new Temperature(new BigDecimal("-47.5612"), 4);
            assertEquals(
                    new BigDecimal("-53.6102"),
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
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
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
                    Temperature.TEMPERATURE_VALUE_TOO_LOW,
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
    @DisplayName("zero, one and two argument constructor tests")
    class TestTemperatureConstructors {

        @Test
        public void testNoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature();
            assertEquals(
                new BigDecimal("0.00"),
                temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }

        @Test
        public void testSingleArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(new BigDecimal("98.76"));
            assertEquals(
                    new BigDecimal("98.76"),
                    temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }

        @Test
        public void testTwoArgumentTemperatureConstructor() {
            Temperature temperature = new Temperature(new BigDecimal("67.89"), 2);
            assertEquals(
                    new BigDecimal("67.89"),
                    temperature.getCelsius()
            );
            assertEquals(
                    2,
                    temperature.getScaleFactor()
            );
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

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
        @Test
        public void testScaleFactorFour() {
            assertAll("Test scale factors four for four digit precision",
                () -> {
                    temperature = new Temperature(new BigDecimal("12.34565"), 4);
                    assertEquals(
                        new BigDecimal("12.3457"),
                        temperature.getCelsius()
                    );
                },
                () -> {
                    Temperature temperature = new Temperature(new BigDecimal("12.34564"), 4);
                    assertEquals(
                        new BigDecimal("12.3456"),
                        temperature.getCelsius()
                    );
                }
            );
        }

        @Test
        public void testScaleFactorNegativeAndTooLarge() {
            assertAll("test scale negative and too large for exceptions",
                () -> {
                    assertEquals(
                        Temperature.SCALE_FACTOR_VALUE_NEGATIVE,
                        assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), -2)
                        ).getMessage()
                    );
                },
                () -> {
                    assertEquals(
                        Temperature.SCALE_FACTOR_VALUE_TOO_LARGE,
                        assertThrows(
                            IllegalArgumentException.class,
                            () -> new Temperature(new BigDecimal("23.45"), 5)
                        ).getMessage()
                    );
                }
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPoints {

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
        public void testSameTemperatureForCelsiusAndFahrenheit() {
            Temperature temperature = new Temperature(new BigDecimal("-40.00"), 2);
            assertEquals(
                    new BigDecimal("-40.00"),
                    temperature.convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testNullValueInSetter() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> temperature.setCelsius(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInSingleArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null)
                    ).getMessage()
            );
        }

        @Test
        public void testNullValueInTwoArgumentConstructor() {
            assertEquals(
                    Temperature.NULL_VALUE_NOT_ALLOWED,
                    assertThrows(
                            NullPointerException.class,
                            () -> new Temperature(null, 2)
                    ).getMessage()
            );
        }
    }
}