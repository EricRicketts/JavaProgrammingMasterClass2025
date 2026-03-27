package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GasPoweredCarTest {

    GasPoweredCar gasPoweredCar;
    Object[] expected, results;

    @BeforeEach
    public void setUp() {
        gasPoweredCar = new GasPoweredCar("Toyota Corolla 2026", 17.60, 4);
    }

    @Test
    public void testAvgKmPerLitreAndCylinders() {
        expected = new Object[]{17.60, 4};
        results = new Object[]{
                Scale.setScale(gasPoweredCar.getAvgKmPerLitre(), 2),
                gasPoweredCar.getCylinders()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testChecksOnAvgKmPerLitreAndCylinders() {
        expected = new Object[]{15.00, 4};
        gasPoweredCar.setAvgKmPerLitre(-1);
        gasPoweredCar.setCylinders(-1);
        results = new Object[]{
                Scale.setScale(gasPoweredCar.getAvgKmPerLitre(), 2),
                gasPoweredCar.getCylinders()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testGasPoweredCarStartEngineDriveAndRunEngine() {
        String[] expected = {
            "Starting the engine on a/an GasPoweredCar, which needs time to warm-up in cold weather.",
            "Driving a/an GasPoweredCar, on a pleasant Spring day.",
            "The engine of a/an GasPoweredCar is running, and is loud given the large amount of horsepower."
        };
        String[] results = {
                gasPoweredCar.startEngine(), gasPoweredCar.drive(), gasPoweredCar.runEngine()
        };
        assertArrayEquals(expected, results);
    }
}
