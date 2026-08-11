package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerTest {

    private Burger burger;

    @BeforeEach
    public void setUp() {
        burger = new Burger(BurgerMeatType.GROUND_HAMBURGER, BurgerSize.MEDIUM);
    }

    @Nested
    @DisplayName("test get and set meat type")
    class TestGetAndSetBurgerMeatType {

        @Test
        public void testGetBurgerMeatType() {
            assertEquals(BurgerMeatType.GROUND_HAMBURGER, burger.getMeatType());
        }

        @Test
        public void testSetBurgerMeatType() {
            assertEquals(BurgerMeatType.GROUND_HAMBURGER, burger.getMeatType());

            burger.setMeatType(BurgerMeatType.SIRLOIN);
            assertEquals(BurgerMeatType.SIRLOIN, burger.getMeatType());
        }
    }

    @Nested
    @DisplayName("test get and set burger size")
    class TestGetAndSetBurgerSize {

        @Test
        public void testGetBurgerMeatSize() {
            assertEquals(BurgerSize.MEDIUM, burger.getSize());
        }

        @Test
        public void testSetBurgerMeatSize() {
            assertEquals(BurgerSize.MEDIUM, burger.getSize());

            burger.setSize(BurgerSize.LARGE);
            assertEquals(BurgerSize.LARGE, burger.getSize());
        }
    }

    @Nested
    @DisplayName("test burger to string")
    class TestBurgerToStringMethod {

        @Test
        public void testToStringMethod() {
            String expected = "Burger Meat Type: GROUND_HAMBURGER, Burger Size: MEDIUM";
            String result = burger.toString();

            assertEquals(expected, result);
        }
    }
}
