package org.example;

import org.junit.jupiter.api.BeforeEach;

public class FishTest {

    Fish fish;

    @BeforeEach
    public void setUp() {
        fish = new Fish("Tuna", 20, 3, 10);
    }
}
