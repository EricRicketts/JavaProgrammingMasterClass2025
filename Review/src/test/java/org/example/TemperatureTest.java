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
    class TestTemperatureGetterAndSetter {

        @Test
        public void testTemperatureGetter() {
            assertEquals(
                    BigDecimal.valueOf(12.34),
                    temperature.getCurrentTemperature()
            );
        }

        @Test
        public void testTemperatureSetter() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(45.67));
            assertEquals(
                    BigDecimal.valueOf(45.67),
                    temperature.getCurrentTemperature()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Fahrenheit")
    class TestConvertValidTemperaturesCelsiusToFahrenheit {

        @Test
        public void testConvertCelsiusToFahrenheitRoundDown() {
            assertEquals(
                    BigDecimal.valueOf(78.31),
                    new Temperature(BigDecimal.valueOf(25.73), 2).convertToFahrenheit()
            );
        }

        @Test
        public void testConvertCelsiusToFahrenheitRoundUp() {
            assertEquals(
                    BigDecimal.valueOf(-53.61),
                    new Temperature(BigDecimal.valueOf(-47.56), 2).convertToFahrenheit()
            );
        }
    }

    @Nested
    @DisplayName("test valid temperature conversions Celsius to Kelvin")
    class TestConvertValidTemperaturesFahrenheitToKelvin {

        @Test
        public void testConvertCelsiusToKelvin() {
            assertEquals(
                    BigDecimal.valueOf(285.49),
                    temperature.convertToKelvin()
            );
        }

        @Test
        public void testConvertNegativeCelsiusToKelvin() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(-123.45));
            assertEquals(
                    NumberUtils.setScale(BigDecimal.valueOf(149.70), 2),
                    temperature.convertToKelvin()
            );
        }
    }

    @Nested
    @DisplayName("check temperature floor for Celsius")
    class TestNegativeFloorForFahrenheitToCelsius {

        @Test
        public void testSetLowestTemperatureForCelsius() {
            temperature.setCurrentTemperature(BigDecimal.valueOf(-273.15));
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCurrentTemperature()
            );
        }

        @Test
        public void testSetLessThanLowestTemperatureForCelsius() {
            assertEquals(
                    Temperature.TEMPERATURE_VIOLATION,
                    assertThrows(
                            IllegalArgumentException.class,
                            () -> temperature.setCurrentTemperature(BigDecimal.valueOf(-273.16))
                    ).getMessage()
            );
        }

        @Test
        public void testInitializeLowestTemperatureForCelsius() {
            Temperature temperature = new Temperature(BigDecimal.valueOf(-273.15), 2);
            assertEquals(
                    BigDecimal.valueOf(-273.15),
                    temperature.getCurrentTemperature()
            );
        }
    }
}
