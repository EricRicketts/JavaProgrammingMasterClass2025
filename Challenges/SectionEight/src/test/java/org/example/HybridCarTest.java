package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridCarTest {

    HybridCar hybridCar;
    String expected, result;

    @BeforeEach
    public void setUp() {
        hybridCar = new HybridCar("Toyota Camry Hybrid 2026", 20.40, 40, 4);
    }

    @Test
    public void testSetAvgKmPerLitre() {
        hybridCar.setAvgKmPerLitre(-1);
        assertEquals(20.00, Scale.setScale(hybridCar.getAvgKmPerLitre(), 2));
    }

    @Test
    public void testSetCylinders() {
        hybridCar.setCylinders(-1);
        assertEquals(4, hybridCar.getCylinders());
    }

    @Test
    public void testStartEngine() {
        expected = "Starting the engine on a/an HybridCar, the gas powered part makes noise but the battery is silent.";
        result = hybridCar.startEngine();
        assertEquals(expected, result);
    }

    @Test
    public void testDrive() {
        expected = "Driving a/an HybridCar, I can get long range " +
                "with this car because of the extra power provided by the battery.";
        result = hybridCar.drive();
        assertEquals(expected, result);
    }

    @Test
    public void testRunEngine() {
        expected = "The engine of a/an HybridCar is running, when on battery only mode the card makes no noise.";
        result = hybridCar.runEngine();
        assertEquals(expected, result);
    }
}
