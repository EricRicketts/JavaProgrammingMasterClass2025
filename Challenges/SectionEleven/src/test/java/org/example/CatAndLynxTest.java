package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatAndLynxTest {

    private Cat cat;
    private Lynx lynx;

    @BeforeEach
    public void setUp() {
        cat = new Cat("Persian", "Large", 15.89);
        lynx = new Lynx("Canadian", "Medium", 24.56);
    }

    @Nested
    @DisplayName("test move method for both animals")
    class TestMoveMethodForCatAndLynxInstances {

        @Test
        public void testMoveMethodForCat() {
            String expected = "Cat (Persian) is walking at 10 km/hr.";
            String result = cat.move("10");

            assertEquals(expected, result);
        }

        @Test
        public void testMoveMethodForLynx() {
            String expected = "Lynx (Canadian) is running at 15 km/hr.";
            String result = lynx.move("15");

            assertEquals(expected, result);
        }
    }
}
