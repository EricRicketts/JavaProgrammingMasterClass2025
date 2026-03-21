package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {

    Fish fish;
    String expected, result;

    @BeforeEach
    public void setUp() {
        fish = new Fish("Tuna", 20, 3, 10);
    }

    @Test
    public void testFishMoveFast() {
        expected = "Muscles Moving.  BackFin Moving.";
        result = fish.move("fast");
        assertEquals(expected, result);
    }

    @Test
    public void testFishMoveSlow() {
        expected = "Muscles Moving.";
        result = fish.move("slow").trim();
        assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        expected = "Fish{fins='10', gills='3'}" +
                " Animal{type='Tuna', size='small', weight=20.0}";
        result = fish.toString();
        assertEquals(expected, result);
    }
}