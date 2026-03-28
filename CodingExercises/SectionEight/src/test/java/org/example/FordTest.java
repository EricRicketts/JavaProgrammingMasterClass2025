package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FordTest {

    Ford ford;

    @BeforeEach
    public void setUp() {
        ford = new Ford(6, "Ford Falcon");
    }

    @Test
    public void testGetCylinders() {
        assertEquals(6, ford.getCylinders());
    }

    @Test
    public void testGetName() {
        assertEquals("Ford", ford.getName());
    }

    @Test
    public void testStartEngine() {
        assertEquals("Ford -> startEngine()", ford.startEngine());
    }

    @Test
    public void testAccelerate() {
        assertEquals("Ford -> accelerate()", ford.accelerate());
    }

    @Test
    public void testBrake() {
        assertEquals("Ford -> brake()", ford.brake());
    }

    @Test
    public void testGetMakeAndModel() {
        assertEquals("Ford Falcon", ford.getMakeAndModel());
    }
}
