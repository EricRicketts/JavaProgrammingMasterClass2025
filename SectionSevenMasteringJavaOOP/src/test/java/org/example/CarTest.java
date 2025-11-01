package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    String expected, result;
    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @Test
    public void testInitialValues() {
        expected = "2-Door- Gray Tesla Model X (convertible)";
        result =  car.describeCar();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetMake() {
        expected = "Tesla";
        result =  car.getMake();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testIsConvertible() {
        Assertions.assertTrue(car.isConvertible());
    }

    @Test
    public void testSetMakeUnsupported() {
        car.setMake("Ford");
        expected = "Unsupported";
        result =  car.getMake();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSetMakeSupported() {
        car.setMake("Porsche");
        expected = "Porsche";
        result =  car.getMake();

        Assertions.assertEquals(expected, result);
    }
}
