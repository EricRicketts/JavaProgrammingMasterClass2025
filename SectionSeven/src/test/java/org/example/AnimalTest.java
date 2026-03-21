package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    Animal animal;
    String expected, result;

    @BeforeEach
    public void setUp() {
        animal = new Animal("Generic Animal", "Huge", 40);
    }

    @Test
    public void testAnimalMoves() {
        expected = "Generic Animal moves at 40km/hr.";
        result = animal.move("40");
        assertEquals(expected, result);
    }

    @Test
    public void testAnimalMakesANoise() {
        expected = "Generic Animal makes some kind of noise.";
        result = animal.makeNoise();
        assertEquals(expected, result);
    }

    @Test
    public void testAnimalToString() {
        expected = "Animal{type='Generic Animal', size='Huge', weight=40.0}";
        result = animal.toString();
        assertEquals(expected, result);
    }
}
