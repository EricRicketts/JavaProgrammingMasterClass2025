package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car baseCar;

    @BeforeEach
    public void setUp() {
        baseCar = new Car();
    }

    @Nested
    @DisplayName("test Car with no argument constructor")
    class TestNoArgumentConstructorCar {

        @Test
        public void testNoArgumentConstructorCarStoresNumberOfDoors() {
            assertEquals(2, baseCar.getNumberOfDoors());
        }

        @Test
        public void testNoArgumentConstructorStoresBrand() {
            assertEquals("Unknown", baseCar.getBrand());
        }

        @Test
        public void testNoArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("0.00"), baseCar.getSpeed());
        }
    }
}
