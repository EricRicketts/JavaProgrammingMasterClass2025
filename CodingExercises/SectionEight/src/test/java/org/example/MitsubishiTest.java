package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MitsubishiTest {


    Mitsubishi mitsubishi;

    @BeforeEach
    public void setUp() {
       mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
    }

    @Test
    public void testGetCylinders() {
        assertEquals(6, mitsubishi.getCylinders());
    }

    @Test
    public void testGetName() {
        assertEquals("Mitsubishi", mitsubishi.getName());
    }

    @Test
    public void testStartEngine() {
        assertEquals("Mitsubishi -> startEngine()", mitsubishi.startEngine());
    }

    @Test
    public void testAccelerate() {
        assertEquals("Mitsubishi -> accelerate()", mitsubishi.accelerate());
    }

    @Test
    public void testBrake() {
        assertEquals("Mitsubishi -> brake()", mitsubishi.brake());
    }

    @Test
    public void testGetMakeAndModel() {
        assertEquals("Outlander VRX 4WD", mitsubishi.getMakeAndModel());
    }
}
