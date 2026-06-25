package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GasPoweredCarTest {

    GasPoweredCar gasPoweredCar;
    Object[] expected, results;

    @BeforeEach
    public void setUp() {
        gasPoweredCar = new GasPoweredCar("Toyota Corolla 2026", new BigDecimal("17.60"), 4);
    }

    @Test
    public void testAvgKmPerLitreAndCylinders() {
        expected = new Object[]{new BigDecimal("17.60"), 4};
        results = new Object[]{
                NumberUtils.setScale(gasPoweredCar.getAvgKmPerLitre(), 2),
                gasPoweredCar.getCylinders()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testChecksOnAvgKmPerLitreAndCylinders() {
        expected = new Object[]{new BigDecimal("15.00"), 4};
        gasPoweredCar.setAvgKmPerLitre(new BigDecimal("-1"));
        gasPoweredCar.setCylinders(-1);
        results = new Object[]{
                NumberUtils.setScale(gasPoweredCar.getAvgKmPerLitre(), 2),
                gasPoweredCar.getCylinders()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testGasPoweredCarStartEngineDriveAndRunEngine() {
        String[] expected = {
            "Starting the engine on a/an GasPoweredCar, which needs time to warm-up in cold weather.",
            "Driving a/an GasPoweredCar on a pleasant Spring day.",
            "The engine of a/an GasPoweredCar is running, and is loud given the large amount of horsepower."
        };
        String[] results = {
                gasPoweredCar.startEngine(), gasPoweredCar.drive(), gasPoweredCar.runEngine()
        };
        assertArrayEquals(expected, results);
    }
}
