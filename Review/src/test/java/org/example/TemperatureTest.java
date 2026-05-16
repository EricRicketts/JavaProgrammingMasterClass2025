package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Fahrenheit")
    class TestConvertValidTemperaturesFahrenheitToCelsius {

        @Test
        public void testConvertFahrenheitToCelsiusRoundDown() {
            assertEquals(
                    78.31,
                    Temperature.convertToFahrenheit(25.73, 2)
            );
        }

        @Test
        public void testConvertFahrenheitToCelsiusRoundUp() {
            assertEquals(
                    -53.61,
                    Temperature.convertToFahrenheit(-47.56, 2)
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Kelvin")
    class TestConvertValidTemperaturesFahrenheitToKelvin {

        @Test
        public void testConvertFahrenheitToKelvinRoundDown() {
            assertEquals(
                    386.69,
                    Temperature.convertToKelvin(113.54, 2)
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            assertEquals(
                    33.39,
                    Temperature.convertToKelvin(-239.76, 2)
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Fahrenheit to Celsius")
    class TestNegativeFloorForFahrenheitToCelsius {

        @Test
        public void testLowestTemperatureForCelsiusToFahrenheitConversion() {
            assertEquals(
                    -459.67,
                    Temperature.convertToFahrenheit(-273.15, 2)
            );
        }

        @Test
        public void testLessThanLowestTemperatureForCelsiusToFahrenheitConversion() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> Temperature.convertToFahrenheit(-273.16, 2)
                    ).getMessage()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Fahrenheit to Kelvin")
    class TestNegativeFloorForFahrenheitToKelvin {

        @Test
        public void testLowestTemperatureForCelsiusToKelvinConversion() {
            assertEquals(
                    0.00,
                    Temperature.convertToKelvin(-273.15, 2)
            );
        }

        @Test
        public void testLessThanLowestTemperatureForCelsiusToKelvinConversion() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> Temperature.convertToKelvin(-273.16, 2)
                    ).getMessage()
            );
        }
    }

}
