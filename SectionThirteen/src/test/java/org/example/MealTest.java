package org.example;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class MealTest {

    private Meal firstMeal, secondMeal;

    @BeforeEach
    public void setUp() {
        firstMeal = new Meal();
        secondMeal = new Meal(new BigDecimal("0.50"));
    }
}
