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
        public void testSingleArgumentConstructorStoresBrand() {
            assertEquals("Toyota", secondUnknownVehicle.getBrand());
        }

        @Test
        public void testSingleArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("0.00"), secondUnknownVehicle.getSpeed());
        }
    }

    @Nested
    @DisplayName("test two argument constructor")
    class TestTwoArgumentConstructor {

        @Test
        public void testTwoArgumentConstructorStoresBrand() {
            assertEquals("Ford", vehicle.getBrand());
        }

        @Test
        public void testTwoArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("25.67"), vehicle.getSpeed());
        }

        @Test
        public void testTwoArgumentConstructorRejectsNegativeSpeed() {
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
            assertEquals(
                "Alfa Romeo",
                new Vehicle("Alfa Romeo", new BigDecimal("45.67")).getBrand()
            );
        }

        @Test
        public void testVehicleSpeedGetter() {
            assertEquals(
                new BigDecimal("33.33"),
                new Vehicle("Chrysler", new BigDecimal("33.33")).getSpeed()
            );
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
        public void testVehicleSpeedSetterRejectsNegativeSpeed() {
            assertEquals(new BigDecimal("25.67"), vehicle.getSpeed());
            assertThrows(
                IllegalArgumentException.class,
                () -> vehicle.setSpeed(new BigDecimal("-13.45"))
            );

            assertEquals(new BigDecimal("25.67"), vehicle.getSpeed());
        }
    }
}
