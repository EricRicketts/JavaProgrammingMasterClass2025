package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    private Animal animal;
    private Animal baseAnimal;

    @BeforeEach
    public void setUp() {
        animal = new Animal("Lion");
        baseAnimal = new Animal();
    }

    @Nested
    @DisplayName("test animal constructors")
    class TestAnimalConstructors {

        @Test
        public void testAnimalNoArgumentConstructorGetName() {
            assertEquals("Unknown Animal", baseAnimal.getName());
        }

        @Test
        public void testAnimalSingleArgumentConstructorGetName() {
            assertEquals("Lion", animal.getName());
        }
    }
}
