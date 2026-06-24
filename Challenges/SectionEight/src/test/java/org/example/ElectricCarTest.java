package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectricCarTest {

    ElectricCar electricCar;
    String expected, result;

    @BeforeEach
    public void setUp() {
        electricCar = new ElectricCar(
                "Tesla Model S",
                new BigDecimal("540.00"),
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

    @Test
    public void testCheckAvgKmPerCharge() {
        BigDecimal defaultAvgKmPerCharge = new BigDecimal("300.00");
        electricCar.setAvgKmPerCharge(new BigDecimal("-10.00"));
        BigDecimal avgKmPerCharge = electricCar.getAvgKmPerCharge();
        avgKmPerCharge = NumberUtils.setScale(avgKmPerCharge, 2);
        assertEquals(defaultAvgKmPerCharge, avgKmPerCharge);
    }

    @Test
    public void testCheckBatterySize() {
        int defaultBatterySize = 50;
        electricCar.setBatterySize(-5);
        int batterySize = electricCar.getBatterySize();
        assertEquals(defaultBatterySize, batterySize);
    }
}