package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CeilingTest {

    Ceiling ceiling;

    @BeforeEach
    public void setUp() {
        ceiling = new Ceiling(120, 345);
    }

    @Test
    public void testCeilingGetters() {
        int[] expected = new int[]{120, 345};
        int[] results = new int[]{ceiling.getHeight(), ceiling.getPaintedColor()};
        assertArrayEquals(expected, results);
    }
}
