package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectricCarTest {

    ElectricCar electricCar;
    String expected, result;

    @BeforeEach
    public void setUp() {
        electricCar = new ElectricCar(
                "Tesla Model S",
                540.00,
                100);
    }

    @Test
    public void testStartEngine() {
        expected = "Starting the engine on a/an ElectricCar, which is the future of all cars.";
        result = electricCar.startEngine();
        assertEquals(expected, result);
    }

    @Test
    public void testDrive() {
        expected = "Driving a/an ElectricCar, which is quite a pleasant experience.";
        result = electricCar.drive();
        assertEquals(expected, result);
    }

    @Test
    public void testRunEngine() {
        expected = "The engine of a/an ElectricCar is running, " +
                "which has no engine but electric motors.";
        result = electricCar.runEngine();
        assertEquals(expected, result);
    }
}
