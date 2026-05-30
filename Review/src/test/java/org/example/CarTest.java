package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car baseCar;
    private Car carSetDoors;
    private Car carSetDoorsAndBrand;

    @BeforeEach
    public void setUp() {
        baseCar = new Car();
        carSetDoors = new Car(4);
        carSetDoorsAndBrand = new Car("GM", 4);
    }

    @Nested
    @DisplayName("test no argument constructor for Car")
    class TestCarNoArgumentConstructor {

        @Test
        public void testCarNoArgumentConstructorCarStoresNumberOfDoors() {
            assertEquals(2, baseCar.getNumberOfDoors());
        }

        @Test
        public void testCarNoArgumentConstructorStoresBrand() {
            assertEquals("Unknown", baseCar.getBrand());
        }

        @Test
        public void testCarNoArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("0.00"), baseCar.getSpeed());
        }
    }

    @Nested
    @DisplayName("test single argument constructor for Car")
    class TestCarSingleArgumentConstructor {

        @Test
        public void testCarSingleArgumentConstructorStoresNumberOfDoors() {
            assertEquals(4, carSetDoors.getNumberOfDoors());
        }

        @Test
        public void testCarSingleArgumentConstructorStoresBrand() {
            assertEquals("Unknown", carSetDoors.getBrand());
        }

        @Test
        public void testCarSingleArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("0.00"), carSetDoors.getSpeed());
        }

        @Test
        public void testCarSingleArgumentConstructorValidatesNumberOfDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Car(-1)
            );
        }
    }

    @Nested
    @DisplayName("test two argument constructor for car")
    class TestCarTwoArgumentConstructor {

        @Test
        public void testCarTwoArgumentConstructorStoresNumberOfDoors() {
            assertEquals(4, carSetDoorsAndBrand.getNumberOfDoors());
        }

        @Test
        public void testCarTwoArgumentConstructorStoresBrand() {
            assertEquals("GM", carSetDoorsAndBrand.getBrand());
        }

        @Test
        public void testCarTwoArgumentConstructorStoresSpeed() {
            assertEquals(new BigDecimal("0.00"), carSetDoorsAndBrand.getSpeed());
        }
    }
}
