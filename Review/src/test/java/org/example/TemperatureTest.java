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

    private static final BigDecimal ABSOLUTE_ZERO = new BigDecimal("-273.15");

    private static final int DEFAULT_SCALE_FACTOR = 2;

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
            assertEquals(new BigDecimal("12.34"), temperature.getCelsius());
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCelsius(new BigDecimal("45.67"));

            assertEquals(new BigDecimal("45.67"), temperature.getCelsius());
        }

        @Test
        public void testScaleFactorGetter() {
            assertEquals(2, temperature.getScaleFactor());
        }

        @Test
        public void testSetterAppliesScaleFactorRoundingUp() {
            Temperature scaledTemperatureRoundUp = new Temperature(new BigDecimal("12.123"), 3);

            scaledTemperatureRoundUp.setCelsius(new BigDecimal("12.3455"));

            assertEquals(new BigDecimal("12.346"), scaledTemperatureRoundUp.getCelsius());
        }

        @Test
        public void testSetterAppliesScaleFactorRoundingDown() {
            Temperature scaledTemperatureRoundDown = new Temperature(new BigDecimal("12.123"), 3);

            scaledTemperatureRoundDown.setCelsius(new BigDecimal("12.3454"));

            assertEquals(new BigDecimal("12.345"), scaledTemperatureRoundDown.getCelsius());
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

        public void testConvertToFahrenheitAllScaleFactors(
            String temperatureValue, int scaleFactor, String expected
        ) {
            Temperature celsiusTemperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

            assertEquals(new BigDecimal(expected), celsiusTemperature.convertToFahrenheit());
        }
    }

    @Nested
    @DisplayName("test convert Celsius to Kelvin")
    class TestConvertCelsiusToKelvin {

        @Test
        public void testConvertPositiveCelsiusToKelvin() {
            assertEquals(new BigDecimal("285.49"), temperature.convertToKelvin());
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCelsius(new BigDecimal("-123.45"));

            assertEquals(new BigDecimal("149.70"), temperature.convertToKelvin());
        }

        @ParameterizedTest
        @CsvSource({
            "0.00, 0, 273",
            "0.00, 1, 273.2",
            "0.00, 2, 273.15",
            "0.00, 3, 273.150",
            "0.00, 4, 273.1500"
        })
        public void testConvertToKelvinAllScaleFactors(
            String temperatureValue,
            int scaleFactor,
            String expected
        ) {
            Temperature celsiusTemperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

            assertEquals(new BigDecimal(expected), celsiusTemperature.convertToKelvin());
        }
    }

    @Nested
    @DisplayName("check temperature boundary for Celsius")
    class TestAbsoluteZeroBoundary {

        @Test
        public void testAbsoluteZeroSetter() {
            temperature.setCelsius(ABSOLUTE_ZERO);

            assertEquals(ABSOLUTE_ZERO, temperature.getCelsius());
        }

        @Test
        public void testSetterRejectsTemperatureBelowAbsoluteZeroAndKeepsPreviousValue() {
            BigDecimal originalTemperature = new BigDecimal("25.00");
            temperature.setCelsius(originalTemperature);

            assertThrows(
                IllegalArgumentException.class,
                () -> temperature.setCelsius(ABSOLUTE_ZERO.subtract(new BigDecimal("0.01")))
            );

            assertEquals(originalTemperature, temperature.getCelsius());
        }

        @Test
        public void testAbsoluteZeroConstructor() {
            Temperature temperatureAbsoluteZero = new Temperature(ABSOLUTE_ZERO, DEFAULT_SCALE_FACTOR);

            assertEquals(ABSOLUTE_ZERO, temperatureAbsoluteZero.getCelsius());
        }

        @Test
        public void testConstructorRejectsTemperatureBelowAbsoluteZero() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(
                    ABSOLUTE_ZERO.subtract(new BigDecimal("0.01")),
                    DEFAULT_SCALE_FACTOR
                )
            );
        }
    }

    @Nested
    @DisplayName("zero, one and two argument constructor tests")
    class TestTemperatureConstructors {

        private static final BigDecimal ZERO = new BigDecimal("0.00");

        private static final String ORIGINAL_TEMPERATURE = "67.98";

        @Test
        public void testNoArgumentConstructor() {
            Temperature temperatureNoArgs = new Temperature();

            assertEquals(ZERO, temperatureNoArgs.getCelsius());
            assertEquals(DEFAULT_SCALE_FACTOR, temperatureNoArgs.getScaleFactor());
        }

        @Test
        public void testOneArgumentConstructor() {
            Temperature temperatureOneArg = new Temperature(new BigDecimal(ORIGINAL_TEMPERATURE));

            assertEquals(new BigDecimal(ORIGINAL_TEMPERATURE), temperatureOneArg.getCelsius());
            assertEquals(DEFAULT_SCALE_FACTOR, temperatureOneArg.getScaleFactor());
        }

        @Test
        public void testTwoArgumentConstructor() {
            Temperature scaledTemperatureTwoArgs = new Temperature(new BigDecimal(ORIGINAL_TEMPERATURE), 3);

            assertEquals(new BigDecimal("67.980"), scaledTemperatureTwoArgs.getCelsius());
            assertEquals(3, scaledTemperatureTwoArgs.getScaleFactor());
        }
    }

    @Nested
    @DisplayName("test different scale factors")
    class TestScaleFactorsForTemperature {

        private static final int MAX_SCALE_FACTOR = 4;

        @ParameterizedTest
        @CsvSource({"87.65, 0, 88", "87.45, 0, 87", "87.65, 1, 87.7", "87.64, 1, 87.6"})
        public void testConstructorsRoundCelsiusToZeroAndOneDecimalPlaces(
            String temperatureValue,
            int scaleFactor,
            String result
        ) {
            Temperature temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

            assertEquals(new BigDecimal(result), temperature.getCelsius());
        }

        @ParameterizedTest
        @CsvSource({"34.455, 2, 34.46", "34.454, 2, 34.45", "87.7475, 3, 87.748", "87.7474, 3, 87.747"})
        public void testConstructorRoundsCelsiusToTwoAndThreeDecimalPlaces(
            String temperatureValue,
            int scaleFactor,
            String result
       ) {
            Temperature temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

            assertEquals(new BigDecimal(result), temperature.getCelsius());
        }

        @ParameterizedTest
        @CsvSource({"12.34565, 4, 12.3457", "12.34564, 4, 12.3456"})
        public void testConstructorRoundsCelsiusToFourDecimalPlaces(
            String temperatureValue,
            int scaleFactor,
            String result
        ) {
            Temperature temperature = new Temperature(new BigDecimal(temperatureValue), scaleFactor);

            assertEquals(new BigDecimal(result), temperature.getCelsius());
            assertEquals(MAX_SCALE_FACTOR, temperature.getScaleFactor());
        }

        @Test
        public void testConstructorRejectsNegativeScaleFactor() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(new BigDecimal("23.45"), -1)
           );
        }

        @Test
        public void testConstructorRejectsTooLargeScaleFactor() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(new BigDecimal("23.45"), MAX_SCALE_FACTOR + 1)
            );
        }
    }

    @Nested
    @DisplayName("test exact freezing and boiling points")
    class TestFreezingAndBoilingPoints {

        @Test
        public void testFreezingPointConversions() {
            Temperature freezingTemperature = new Temperature(new BigDecimal("0.00"), DEFAULT_SCALE_FACTOR);

            assertEquals(new BigDecimal("32.00"), freezingTemperature.convertToFahrenheit());
            assertEquals(new BigDecimal("273.15"), freezingTemperature.convertToKelvin());
        }

        @Test
        public void testBoilingPointConversions() {
            Temperature boilingTemperature = new Temperature(new BigDecimal("100.00"), DEFAULT_SCALE_FACTOR);

            assertEquals(new BigDecimal("212.00"), boilingTemperature.convertToFahrenheit());
            assertEquals(new BigDecimal("373.15"), boilingTemperature.convertToKelvin());
        }

        @Test
        public void testNegativeFortyCelsiusEqualsNegativeFortyFahrenheit() {
            Temperature temperature = new Temperature(new BigDecimal("-40.00"), DEFAULT_SCALE_FACTOR);

            assertEquals(new BigDecimal("-40.00"), temperature.convertToFahrenheit());
        }
    }

    @Nested
    @DisplayName("test null values in setters and constructors")
    class TestNullValuesInSettersAndConstructors {

        @Test
        public void testTemperatureSetterRejectsNullValueAndKeepsOriginalTemperature() {
            BigDecimal originalTemperature = temperature.getCelsius();

            assertThrows(
                IllegalArgumentException.class,
                () -> temperature.setCelsius(null)
            );

            assertEquals(originalTemperature, temperature.getCelsius());
        }

        @Test
        public void testTemperatureOneArgumentConstructorRejectsNullValue() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(null)
            );
        }

        @Test
        public void testTemperatureTwoArgumentConstructorRejectsNullValue() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Temperature(null, DEFAULT_SCALE_FACTOR)
            );
        }
    }
}