package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BedTest {

    Bed bed;

    @BeforeEach
    public void setUp() {
        bed = new Bed("King", 2, 36, 2, 1);
    }

    @Test
    public void testBedGetters() {
        Object[] expected = new Object[]{"King", 2, 36, 2, 1};
        Object[] result = new Object[]{
                bed.getStyle(), bed.getPillows(), bed.getHeight(),
                bed.getSheets(), bed.getQuilt()
        };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMakeTheBed() {
        assertEquals("The bed is currently being made.", bed.make());
    }
}
