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
        expected = "Dogs walk, run and wag their tail.";
        result = dog.move("30");
        assertEquals(expected, result);
    }

    @Test
    public void testDogMakesANoise() {
        expected = "The noise most common for a Dog is to bark.";
        result = dog.makeNoise();
        assertEquals(expected, result);
    }

    @Test
    public void testZeroArgumentDogConstructor() {
        expected = "Dog{earShape='null', tailShape='null'}" +
                " Animal{type='Mutt', size='Big', weight=50.0}";
        result = dog.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testTwoArgumentDogConstructor() {
        expected = "Dog{earShape='Perky', tailShape='Curled'}" +
                " Animal{type='Poodle', size='medium', weight=20.0}";
        dog = new Dog("Poodle", 20);
        result = dog.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testFourArgumentDogConstructor() {
        expected = "Dog{earShape='Flat', tailShape='Straight'}" +
                " Animal{type='Labrador', size='large', weight=45.0}";
        dog = new Dog("Labrador", 45, "Flat", "Straight");
        result = dog.toString();
        assertEquals(expected, result);
    }
}
