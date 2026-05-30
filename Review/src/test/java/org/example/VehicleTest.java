package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTest {

    private Vehicle vehicle;

    private Vehicle firstUnknownVehicle;

    private Vehicle secondUnknownVehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle("Ford", new BigDecimal("25.67"));
        firstUnknownVehicle = new Vehicle();
        secondUnknownVehicle = new Vehicle("Toyota");
    }

    @Nested
    @DisplayName("test no argument constructor")
    class TestNoArgumentConstructor {

        @Test
        public void testNoArgumentConstructorStoresValidBrand() {
            assertEquals("Unknown", firstUnknownVehicle.getBrand());
        }

        @Test
        public void testNoArgumentConstructorStoresValidSpeed() {
            assertEquals(new BigDecimal("0.00"), firstUnknownVehicle.getSpeed());
        }
    }

    @Nested
    @DisplayName("test single argument constructor")
    class TestSingleArgumentConstructor {

        @Test
        public void testSingleArgumentConstructorStoresValidBrand() {
            assertEquals("Toyota", secondUnknownVehicle.getBrand());
        }

        @Test
        public void testSingleArgumentConstructorStoresValidSpeed() {
            assertEquals(new BigDecimal("0.00"), secondUnknownVehicle.getSpeed());
        }
    }

    @Nested
    @DisplayName("test two argument constructor")
    class TestTwoArgumentConstructor {

        @Test
        public void testTwoArgumentConstructorStoresValidBrand() {
            assertEquals("Ford", vehicle.getBrand());
        }

        @Test
        public void testTwoArgumentConstructorStoresValidSpeed() {
            assertEquals(new BigDecimal("25.67"), vehicle.getSpeed());
        }

        @Test
        public void testTwoArgumentConstructorValidatesSpeed() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Vehicle("GM", new BigDecimal("-10.98"))
            );
        }
    }

    @Nested
    @DisplayName("test vehicle getters")
    class TestVehicleGetters {

        @Test
        public void testVehicleBrandGetter() {
            assertEquals("Ford", vehicle.getBrand());
        }

        @Test
        public void testVehicleSpeedGetter() {
            assertEquals(new BigDecimal("25.67"), vehicle.getSpeed());
        }
    }

    @Nested
    @DisplayName("test vehicle setters")
    class TestVehicleSetters {

        @Test
        public void testVehicleBrandSetter() {
            vehicle.setBrand("Nissan");

            assertEquals("Nissan", vehicle.getBrand());
        }

        @Test
        public void testVehicleSpeedSetter() {
            vehicle.setSpeed(new BigDecimal("45.89"));

            assertEquals(new BigDecimal("45.89"), vehicle.getSpeed());
        }

        @Test
        public void testVehicleSpeedSetterValidatesSpeed() {
            assertThrows(
                IllegalArgumentException.class,
                () -> vehicle.setSpeed(new BigDecimal("-13.45"))
            );
        }
    }
}
