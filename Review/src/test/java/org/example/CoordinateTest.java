package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest {

    private Coordinate point;

    @BeforeEach
    public void setUp() {
        point = new Coordinate(8, 10);
    }

    @Test
    public void testGetXCoord() {
        assertEquals(8, point.x());
    }

    @Test
    public void testGetYCoord() {
        assertEquals(10, point.y());
    }
}
