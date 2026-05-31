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
    private Car customCar;

    @BeforeEach
    public void setUp() {
        baseCar = new Car();
        carSetDoors = new Car(4);
        carSetDoorsAndBrand = new Car("GM", 4);
        customCar = new Car("Ford", new BigDecimal("60.12"), 2);
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
        public void testCarSingleArgumentConstructorRejectsZeroDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Car(0)
            );
        }

        @Test
        public void testCarSingleArgumentConstructorRejectsNegativeDoors() {
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

        @Test
        public void testCarTwoArgumentConstructorRejectsNegativeSpeed () {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Car("Toyota", new BigDecimal("-5.43"), 2)
            );
        }

        @Test
        public void testCarTwoArgumentConstructorRejectsZeroDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Car("Honda", new BigDecimal("56.89"), 0)
            );
        }

        @Test
        public void testCarTwoArgumentConstructorRejectsNegativeDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Car("Bugatti", new BigDecimal("23.45"), -3)
            );
        }
    }

    @Nested
    @DisplayName("test Car getters")
    class TestCarGetters {

        @Test
        public void testCarBrandGetter() {
            assertEquals("Ford", customCar.getBrand());
        }

        @Test
        public void testCarSpeedGetter() {
            assertEquals(new BigDecimal("60.12"), customCar.getSpeed());
        }

        @Test
        public void testCarNumberOfDoorsGetter() {
            assertEquals(2, customCar.getNumberOfDoors());
        }
    }

    @Nested
    @DisplayName("test Car setters")
    class TestCarSetters {

        @Test
        public void testCarBrandSetter() {
            customCar.setBrand("Bugatti");

            assertEquals("Bugatti", customCar.getBrand());
        }

        @Test
        public void testCarSpeedSetter() {
            customCar.setSpeed(new BigDecimal("12.34"));

            assertEquals(new BigDecimal("12.34"), customCar.getSpeed());
        }

        @Test
        public void testCarNumberOfDoorsSetter() {
            customCar.setNumberOfDoors(5);

            assertEquals(5, customCar.getNumberOfDoors());
        }

        @Test
        public void testCarSpeedSetterRejectsSpeedBelowZero() {
            assertEquals(new BigDecimal("60.12"), customCar.getSpeed());
            assertThrows(
                IllegalArgumentException.class,
                () -> customCar.setSpeed(new BigDecimal("-12.34"))
            );

            assertEquals(new BigDecimal("60.12"), customCar.getSpeed());
        }

        @Test
        public void testCarNumberOfDoorsSetterRejectsZeroDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> customCar.setNumberOfDoors(0)
            );
        }

        @Test
        public void testCarNumberOfDoorsSetterRejectsNegativeDoors() {
            assertThrows(
                IllegalArgumentException.class,
                () -> customCar.setNumberOfDoors(-1)
            );
        }
    }
}
