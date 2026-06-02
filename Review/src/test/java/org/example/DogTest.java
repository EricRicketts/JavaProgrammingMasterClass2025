package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    }
}
