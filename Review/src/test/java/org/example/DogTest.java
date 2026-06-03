package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DogTest {

    private Dog dog;
    private Dog baseDog;
    private Dog customDog;

    @BeforeEach
    public void setUp() {
        baseDog = new Dog();
        dog = new Dog("German Shepherd");
        customDog = new Dog("Bulldog", Animal.Size.MEDIUM);
    }

    @Nested
    @DisplayName("test dog two argument constructor validates name")
    class TestDogTwoArgumentConstructorRejectsInvalidName {

        @Test
        public void testDogTwoArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Dog(null, Animal.Size.SMALL)
            );
        }

        @Test
        public void TestDogTwoArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Dog("", Animal.Size.MEDIUM)
            );
        }

        @Test
        public void testDogTwoArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Dog(" ", Animal.Size.LARGE)
            );
        }
    }

    @Nested
    @DisplayName("test dog single argument constructor validates name")
    class TestDogSingleArgumentConstructorRejectsInvalidName {

        @Test
        public void testDogSingleArgumentConstructorRejectsNullName() {
            assertThrows(
                NullPointerException.class,
                () -> new Dog(null)
            );
        }

        @Test
        public void testDogSingleArgumentConstructorRejectsEmptyName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Dog("")
            );
        }

        @Test
        public void testDogSingleArgumentConstructorRejectsBlankName() {
            assertThrows(
                IllegalArgumentException.class,
                () -> new Dog(" ")
            );
        }
    }

    @Nested
    @DisplayName("test no argument dog constructor getters")
    class TestDogNoArgumentConstructorGetters {

        @Test
        public void testDogNoArgumentConstructorGetName() {
            assertEquals("Unknown Name", baseDog.getName());
        }

        @Test
        public void testDogNoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, baseDog.getSize());
        }
    }

    @Nested
    @DisplayName("test single argument dog constructor getters")
    class TestDogSingleArgumentConstructorGetters {

        @Test
        public void testDogSingleArgumentConstructorGetName() {
            assertEquals("German Shepherd", dog.getName());
        }

        @Test
        public void testDogSingleArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, dog.getSize());
        }
    }

    @Nested
    @DisplayName("test two argument dog constructor getters")
    class TestDogTwoArgumentConstructorGetters {

        @Test
        public void testDogTwoArgumentConstructorGetName() {
            assertEquals("Bulldog", customDog.getName());
        }

        @Test
        public void testDogTwoArgumentConstructorGetSize() {
            assertEquals(Animal.Size.MEDIUM, customDog.getSize());
        }
    }

    @Nested
    @DisplayName("test dog no argument constructor setters")
    class TestDogNoArgumentConstructorSetters {

        @Test
        public void testDogNoArgumentConstructorSetName() {
            assertEquals("Unknown Name", baseDog.getName());
            baseDog.setName("New name");

            assertEquals("New name", baseDog.getName());
        }

        @Test
        public void testDogNoArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, baseDog.getSize());
            baseDog.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, baseDog.getSize());
        }
    }

    @Nested
    @DisplayName("test dog single argument constructor setters")
    class TestDogSingleArgumentConstructorSetters {

        @Test
        public void testDogSingleArgumentConstructorSetName() {
            assertEquals("German Shepherd", dog.getName());
            dog.setName("Labrador");

            assertEquals("Labrador", dog.getName());
        }

        @Test
        public void testDogSingleArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, dog.getSize());
            dog.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, dog.getSize());
        }
    }

    @Nested
    @DisplayName("test dog two argument constructor setters")
    class TestDogTwoArgumentConstructorSetters {

        @Test
        public void testDogTwoArgumentConstructorSetName() {
            assertEquals("Bulldog", customDog.getName());
            customDog.setName("Bull Terrier");

            assertEquals("Bull Terrier", customDog.getName());
        }

        @Test
        public void testDogTwoArgumentConstructorSetSize() {
            assertEquals(Animal.Size.MEDIUM, customDog.getSize());
            customDog.setSize(Animal.Size.LARGE);

            assertEquals(Animal.Size.LARGE, customDog.getSize());
        }
    }

    @Nested
    @DisplayName("test dog setter rejects invalid name")
    class TestDogSetterRejectsInvalidName {

    }

    @Nested
    @DisplayName("test dog make sound and trained status")
    class TestDogMakeSoundAndTrainedStatus {

    }
}
