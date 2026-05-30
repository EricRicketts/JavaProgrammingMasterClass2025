package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    private Vehicle vehicle;
    private Vehicle unknownVehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle("Ford", new BigDecimal("25.67"));
    }

    @Nested
    @DisplayName("test no argument constructor")
    class TestNoArgumentConstructor {

        @Test
        public void testNoArgumentConstructorHasValidBrand() {
            unknownVehicle = new Vehicle();

            assertEquals("Unknown", unknownVehicle.getBrand());
        }

        @Test
        public void testNoArgumentConstructorHasValidSpeed() {
            unknownVehicle = new Vehicle();

            assertEquals(new BigDecimal("0.00"), unknownVehicle.getSpeed());
        }
    }
}
