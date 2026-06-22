package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;

    @BeforeEach
    public void setUp() {
        coffeeMaker = new CoffeeMaker(false);
    }

    @Nested
    @DisplayName("test coffee maker getter for has work to do")
    class TestCoffeeMakerGetterHasWorkToDo {

        @Test
        public void testCoffeeMakerHasWorkToDo() {
            assertFalse(coffeeMaker.isHasWorkToDo());
        }
    }

    @Nested
    @DisplayName("test coffee maker setters for has work to do")
    class TestCoffeeMakerSettersHasWorkToDo {

        @Test
        public void testCoffeeMakerSetterHasWorkToDoTrue() {
            assertFalse(coffeeMaker.isHasWorkToDo());

            coffeeMaker.setHasWorkToDo(true);

            assertTrue(coffeeMaker.isHasWorkToDo());
        }

        @Test
        public void testCoffeeMakerSetterHasWorkToDoFalse() {
            assertFalse(coffeeMaker.isHasWorkToDo());
            coffeeMaker.setHasWorkToDo(true);

            assertTrue(coffeeMaker.isHasWorkToDo());
            coffeeMaker.setHasWorkToDo(false);

            assertFalse(coffeeMaker.isHasWorkToDo());
        }

        @Test
        public void testCoffeeMakerSetterAddWater() {
            coffeeMaker.setHasWorkToDo(false);

            assertFalse(coffeeMaker.isHasWorkToDo());
            coffeeMaker.addWater();

            assertTrue(coffeeMaker.isHasWorkToDo());
        }
    }

}
