package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceTest {

    Place place;

    @BeforeEach
    public void setUp() {
        place = new Place("FooBar", 345);
    }

    @Test
    public void testName() {
        assertEquals("FooBar", place.name());
    }

    @Test
    public void testDistance() {
        assertEquals(345, place.distance());
    }
}
