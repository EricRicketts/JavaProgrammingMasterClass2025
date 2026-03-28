package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car(8, "Base Car");
    }

    @Test
    public void testGetCylinders() {
        assertEquals(8, car.getCylinders());
    }

    @Test
    public void testGetName() {
        assertEquals("Car", car.getName());
    }

    @Test
    public void testStartEngine() {
        assertEquals("Car -> startEngine()", car.startEngine());
    }

    @Test
    public void testAccelerate() {
        assertEquals("Car -> accelerate()", car.accelerate());
    }

    @Test
    public void testBrake() {
        assertEquals("Car -> brake()", car.brake());
    }

    @Test
    public void testGetMakeAndModel() {
        assertEquals("Base Car", car.getMakeAndModel());
    }
}
