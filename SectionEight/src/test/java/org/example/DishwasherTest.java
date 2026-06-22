package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DishwasherTest {

    private DishWasher dishwasher;

    @BeforeEach
    public void setUp() {
        dishwasher = new DishWasher(false);
    }

    @Nested
    @DisplayName("test dishwasher getter for has work to do")
    class TestDishWasherGetterHasWorkToDo {

        @Test
        public void testDishWasherHasWorkToDo() {
            assertFalse(dishwasher.isHasWorkToDo());
        }
    }

    @Nested
    @DisplayName("test dishwasher setters for has work to do")
    class TestDishWasherSettersHasWorkToDo {

        @Test
        public void testDishWasherSetterHasWorkToDoTrue() {
            assertFalse(dishwasher.isHasWorkToDo());

            dishwasher.setHasWorkToDo(true);

            assertTrue(dishwasher.isHasWorkToDo());
        }

        @Test
        public void testDishWasherSetterHasWorkToDoFalse() {
            assertFalse(dishwasher.isHasWorkToDo());
            dishwasher.setHasWorkToDo(true);

            assertTrue(dishwasher.isHasWorkToDo());
            dishwasher.setHasWorkToDo(false);

            assertFalse(dishwasher.isHasWorkToDo());
        }

        @Test
        public void testDishWasherSetterAddWater() {
            dishwasher.setHasWorkToDo(false);

            assertFalse(dishwasher.isHasWorkToDo());
            dishwasher.loadDishwasher();

            assertTrue(dishwasher.isHasWorkToDo());
        }
    }

    @Nested
    @DisplayName("test dishwasher on or off")
    class TestDishWasherOnOrOff {

        @Test
        public void testDishwasherOn() {
            dishwasher.setHasWorkToDo(true);

            assertEquals("The dishwasher is on.", dishwasher.doDishes());
        }

        @Test
        public void testDishwasherOff() {
            dishwasher.setHasWorkToDo(false);

            assertEquals("The dishwasher is off.", dishwasher.doDishes());
        }
    }
}
