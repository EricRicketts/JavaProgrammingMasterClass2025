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

    private Animal customAnimal;

    @BeforeEach
    public void setUp() {
        customAnimal = new Animal("Jaguar", Animal.Size.SMALL);
        animal = new Animal("Lion");
        baseAnimal = new Animal();
    }

    @Nested
    @DisplayName("test animal two argument constructor validates name")
    class TestAnimalTwoArgumentConstructorRejectsInvalidName {

        @Test
        public void testAnimalTwoArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Animal(null, Animal.Size.EXTRA_LARGE)
            );
        }

        @Test
        public void testAnimalTwoArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Animal("", Animal.Size.LARGE)
            );
        }

        @Test
        public void testAnimalTwoArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Animal("  ", Animal.Size.MEDIUM)
            );
        }
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
    @DisplayName("test no argument animal constructor getters")
    class TestNoArgumentAnimalConstructorGetters {

        @Test
        public void testAnimalNoArgumentConstructorGetName() {
            assertEquals("Unknown Animal", baseAnimal.getName());
        }

        @Test
        public void testAnimalNoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, baseAnimal.getSize());
        }
    }

    @Nested
    @DisplayName("test single argument animal constructor getters")
    class TestSingleArgumentAnimalConstructorGetters {

        @Test
        public void testSingleArgumentAnimalConstructorGetName() {
            assertEquals("Lion", animal.getName());
        }

        @Test
        public void testSingleArgumentAnimalConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, animal.getSize());
        }
    }

    @Nested
    @DisplayName("test two argument animal constructor getters")
    class TestTwoArgumentAnimalConstructorGetters {

        @Test
        public void testAnimalTwoArgumentConstructorGetName() {
            assertEquals("Jaguar", customAnimal.getName());
        }

        @Test
        public void testAnimalTwoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.SMALL, customAnimal.getSize());
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

        @Test
        public void testAnimalTwoArgumentConstructorSetName() {
            assertEquals("Jaguar", customAnimal.getName());
            customAnimal.setName("Leopard");

            assertEquals("Leopard", customAnimal.getName());
        }

        @Test
        public void testAnimalTwoArgumentConstructorSetSize() {
            assertEquals(Animal.Size.SMALL, customAnimal.getSize());
            customAnimal.setSize(Animal.Size.MEDIUM);

            assertEquals(Animal.Size.MEDIUM, customAnimal.getSize());
        }
    }

    @Nested
    @DisplayName("test animal setter rejects invalid names")
    class TestAnimalSetterRejectsInvalidName {

        @Test
        public void testAnimalSetterRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> animal.setName(null)
            );
        }

        @Test
        public void testAnimalSetterRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> animal.setName("")
            );
        }

        @Test
        public void testAnimalSetterRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> animal.setName("  ")
            );
        }
    }

    @Nested
    @DisplayName("test make sourd method")
    class TestAnimalMakeSound {

        @Test
        public void testAnimalMakeSourd() {
            assertEquals("Generic animal sound", animal.makeSound());
        }
    }
}
