package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarpetTest {

    Carpet carpet;
    double expected, result;

    @Test
    public void testCostLessThanZero() {
        expected = 0;
        carpet = new Carpet(-1.55);
        result = carpet.getCost();
        assertEquals(expected, result);
    }

    @Test
    public void testValidCarpetCost() {
        expected = 3.45;
        carpet = new Carpet(expected);
        result = carpet.getCost();
        assertEquals(expected, result);
    }
}
