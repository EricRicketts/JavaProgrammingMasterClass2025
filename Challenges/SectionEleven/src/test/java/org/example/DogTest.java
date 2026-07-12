package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {

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
}
