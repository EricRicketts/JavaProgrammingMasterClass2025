package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoldenTest {

    Holden holden;

    @BeforeEach
    public void setUp() {
        holden = new Holden(6, "Holden Commodore");
    }

    @Test
    public void testGetCylinders() {
        assertEquals(6, holden.getCylinders());
    }

    @Test
    public void testGetName() {
        assertEquals("Holden", holden.getName());
    }

    @Test
    public void testStartEngine() {
        assertEquals("Holden -> startEngine()", holden.startEngine());
    }

    @Test
    public void testAccelerate() {
        assertEquals("Holden -> accelerate()", holden.accelerate());
    }

    @Test
    public void testBrake() {
        assertEquals("Holden -> brake()", holden.brake());
    }

    @Test
    public void testGetMakeAndModel() {
        assertEquals("Holden Commodore", holden.getMakeAndModel());
    }
}
