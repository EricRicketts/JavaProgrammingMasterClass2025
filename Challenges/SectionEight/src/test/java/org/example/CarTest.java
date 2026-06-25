package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car;
    String expected, result;

    @BeforeEach
    public void setUp() {
        car = new Car("A generic car.");
    }

    @Nested
    @DisplayName("test car description field getter and setter")
    class TestCarDescriptionField{

        @Test
        public void testGetDescription() {
            expected = "A generic car.";
            result = car.getDescription();
            assertEquals(expected, result);
        }

        @Test
        public void testSetDescription() {
            expected = "Another generic car.";
            car.setDescription("Another generic car.");
            result = car.getDescription();
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test car engine")
    class TestCarEngine {

        @Test
        public void testStartEngineOnTheBaseCar() {
            expected = "Starting the engine on a/an Car";
            result = car.startEngine();
            assertEquals(expected, result);
        }

        @Test
        public void testRunEngineOnTheBaseCar() {
            expected = "The engine of a/an Car is running";
            result = car.runEngine();
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test driving car")
    class TestDrivingCar {

        @Test
        public void testDrivingTheBaseCar() {
            expected = "Driving a/an Car";
            result = car.drive();
            assertEquals(expected, result);
        }
    }
}
