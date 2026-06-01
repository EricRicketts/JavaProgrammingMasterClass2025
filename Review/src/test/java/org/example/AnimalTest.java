package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    private Animal animal;
    private Animal baseAnimal;

    @BeforeEach
    public void setUp() {
        animal = new Animal("Lion");
        baseAnimal = new Animal();
    }

    @Nested
    @DisplayName("test animal single argument constructor validates Name")
    class TestAnimalSingleArgumentConstructorRejectsInvalidName {

        @Test
        public void testAnimalSingleArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Animal(null)
            );
        }

        @Test
        public void testAnimalSingleArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Animal("")
            );
        }

        @Test
        public void testAnimalSingleArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Animal("  ")
            );
        }
    }

    @Nested
    @DisplayName("test animal getters")
    class TestAnimalGetters {

        @Test
        public void testAnimalNoArgumentConstructorGetName() {
            assertEquals("Unknown Animal", baseAnimal.getName());
        }

        @Test
        public void testAnimalSingleArgumentConstructorGetName() {
            assertEquals("Lion", animal.getName());
        }
    }

    @Nested
    @DisplayName("test animal setters")
    class TestAnimalSetters {

        @Test
        public void testAnimalNoArgumentConstructorSetName() {
            assertEquals("Unknown Animal", baseAnimal.getName());
            baseAnimal.setName("Another Unknown Animal");

            assertEquals("Another Unknown Animal", baseAnimal.getName());
        }

        @Test
        public void testAnimalSingleArgumentConstructorSetName() {
            assertEquals("Lion", animal.getName());
            animal.setName("Tiger");

            assertEquals("Tiger", animal.getName());
        }
    }
}
