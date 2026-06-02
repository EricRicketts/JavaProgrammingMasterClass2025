package org.example;

import org.junit.jupiter.api.BeforeEach;

public class DogTest {

    private Dog dog;
    private Dog baseDog;
    private Dog customDog;

    @BeforeEach
    public void setUp() {
        dog = new Dog("German Shepherd");
        baseDog = new Dog();
        customDog = new Dog("Bulldog", Animal.Size.MEDIUM);
    }
}
