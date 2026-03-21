package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

    Dog dog;
    String expected, result;

    @BeforeEach
    public void setUp() {
        dog = new Dog();
    }

    @Test
    public void testAnimalMoves() {
        expected = "Mutt moves at 30km/hr.";
        result = dog.move("30");
        assertEquals(expected, result);
    }

    @Test
    public void testDogMakesANoise() {
        expected = "Mutt makes some kind of noise.";
        result = dog.makeNoise();
        assertEquals(expected, result);
    }

    @Test
    public void testAnimalToString() {
        expected = "Animal{type='Mutt', size='Big', weight=50.0}";
        result = dog.toString();
        assertEquals(expected, result);
    }
}
