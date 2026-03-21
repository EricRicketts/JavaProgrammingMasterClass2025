package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloorTest {

    Floor floor;
    double expected, result;

    @Test
    public void testFloorWithNegativeDimensions() {
        floor = new Floor(-1.45, 4.5);
        expected = 0;
        result = floor.getArea();
        assertEquals(expected, result);
    }

    @Test
    public void testFloorWithValidInput() {
        floor = new Floor(5.4, 6.3);
        expected = 34.02;
        result = ScaleOutput.setScaleTo(floor.getArea(), 2);
        assertEquals(expected, result);
    }
}
