package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car;
    String expected, result;

    @BeforeEach
    public void setUp() {
        car = new Car("A generic car.");
    }

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

    @Test
    public void testStartEngineOnTheBaseCar() {
        expected = "Starting the engine on a/an Car.";
        result = car.startEngine();
        assertEquals(expected, result);
    }

    @Test
    public void testDrivingTheBaseCar() {
        expected = "Driving a/an Car.";
        result = car.drive();
        assertEquals(expected, result);
    }

    @Test
    public void testRunEngineOnTheBaseCar() {
        expected = "The engine of a/an Car is running.";
        result = car.runEngine();
        assertEquals(expected, result);
    }
}
