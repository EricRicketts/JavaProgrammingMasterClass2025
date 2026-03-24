package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LampTest {

    Lamp lamp;

    @BeforeEach
    public void setUp() {
        lamp = new Lamp("Tree", false, 1600);
    }

    @Test
    public void testLampGetters() {
        Object[] expected = new Object[]{
                "Tree", false, 1600
        };
        Object[] results = new Object[]{
                lamp.getStyle(), lamp.isBattery(), lamp.getGlobRating()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testTurnOnTheLamp() {
        assertEquals("The lamp is turned on.", lamp.turnOn());
    }
}
