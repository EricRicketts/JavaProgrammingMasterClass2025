package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogAndWolfTest {

    private static String doAnimalStuff(Animal animal) {
        return animal.makeNoise() + " " + animal.move("10");
    }
    private Dog dog;

    @BeforeEach
    public void setUp() {
        dog = new Dog("Greyhound", "Large", 33.45);
    }

    @Nested
    @DisplayName("test getters")
    class TestDogGetters {

        @Test
        public void testGetDogType() {
            assertEquals("Greyhound", dog.getType());
        }

        @Test
        public void testGetDogSize() {
            assertEquals("Large", dog.getSize());
        }

        @Test
        public void testGetDogWeight() {
            assertEquals(33.45, dog.getWeight());
        }
    }

    @Nested
    @DisplayName("test move method")
    class TestDogMoveMethod {

        @Test
        public void testMoveMethod() {
            String expected = "Dog (Greyhound) is loping at 9 km/hr.";
            String result = dog.move("9");

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test make noise method")
    class TestDogMakeNoiseMethod {

        @Test
        public void testAnimalIsWolf() {
            Dog wolf = new Dog("Wolf", "Large", 13.34);
            assertEquals("Howling!", wolf.makeNoise());
        }

        @Test
        public void testAnimalIsNotWolf() {
            assertEquals("Woff!", dog.makeNoise());
        }
    }

    @Nested
    @DisplayName("teat animal do stuff method")
    class TestDoAnimalStuffMethod {

        @Test
        public void testDoAnimalStuffWithDog() {
            String expected = "Woff! Dog (Greyhound) is loping at 10 km/hr.";
            String result = doAnimalStuff(dog);

            assertEquals(expected, result);
        }

        @Test
        public void testDoAnimalStuffWithWolf() {
            Wolf wolf = new Wolf("Wolf", "Large", 13.34);
            String expected = "Howling! Wolf (Wolf) is loping at 10 km/hr.";
            String result = doAnimalStuff(wolf);

            assertEquals(expected, result);
        }
    }
}
