package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTest {

    @Nested
    @DisplayName("test valid temperature conversions Fahrenheit to Celsius")
    class TestConvertValidTemperaturesFahrenheitToCelsius {

        @Test
        public void testConvertFahrenheitToCelsiusRoundDown() {
            assertEquals(
                    25.73,
                    Temperature.convertToCelsius(78.32, 2)
            );
        }

        @Test
        public void testConvertFahrenheitToCelsiusRoundUp() {
            assertEquals(
                    -47.09,
                    Temperature.convertToCelsius(-52.76, 2)
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Fahrenheit to Kelvin")
    class TestConvertValidTemperaturesFahrenheitToKelvin {

        @Test
        public void testConvertFahrenheitToKelvinRoundDown() {
            assertEquals(
                    388.57,
                    Temperature.convertToKelvin(239.76, 2)
            );
        }

        @Test
        public void testConvertFahrenheitToKelvinRoundUp() {
            assertEquals(
                    245.99,
                    Temperature.convertToKelvin(-16.89, 2)
            );
        }
    }

    @Nested
    @DisplayName("check negative floor for Fahrenheit")
    class TestNegativeFloorForFahrenheit {

        @Test
        public void testLowestTemperatureForCelsius() {
            assertEquals(
                    -273.15,
                    Temperature.convertToCelsius(-459.67, 2)
            );
        }

        @Test
        public void testUnderLowestTemperatureForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> Temperature.convertToCelsius(-459.68, 2)
                    ).getMessage()
            );
        }
    }
}
