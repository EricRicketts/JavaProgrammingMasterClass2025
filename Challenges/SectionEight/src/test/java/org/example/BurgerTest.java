package org.example;

import org.junit.jupiter.api.BeforeEach;

public class BurgerTest {

    Burger burger, smallBurger, largeBurger;

    @BeforeEach
    public void setUp() {
        smallBurger = new Burger("small", 15.00);
    }
}
