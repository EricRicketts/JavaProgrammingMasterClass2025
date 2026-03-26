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
    public void setDescription() {
        expected = "Another generic car.";
        car.setDescription("Another generic car.");
        result = car.getDescription();
        assertEquals(expected, result);
    }
}
