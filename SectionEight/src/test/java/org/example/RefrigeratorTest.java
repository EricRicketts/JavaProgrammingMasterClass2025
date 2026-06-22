package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefrigeratorTest {

    private Refrigerator refrigerator;

    @BeforeEach
    public void setUp() {
        refrigerator = new Refrigerator(false);
    }

    @Nested
    @DisplayName("test refrigerator getter for has work to do")
    class TestRefrigeratorGetterHasWorkToDo {

        @Test
        public void testRefrigeratorHasWorkToDo() {
            assertFalse(refrigerator.isHasWorkToDo());
        }
    }

    @Nested
    @DisplayName("test refrigerator setters for has work to do")
    class TestRefrigeratorSettersHasWorkToDo {

        @Test
        public void testRefrigeratorSetterHasWorkToDoTrue() {
            assertFalse(refrigerator.isHasWorkToDo());

            refrigerator.setHasWorkToDo(true);

            assertTrue(refrigerator.isHasWorkToDo());
        }

        @Test
        public void testRefrigeratorSetterHasWorkToDoFalse() {
            assertFalse(refrigerator.isHasWorkToDo());
            refrigerator.setHasWorkToDo(true);

            assertTrue(refrigerator.isHasWorkToDo());
            refrigerator.setHasWorkToDo(false);

            assertFalse(refrigerator.isHasWorkToDo());
        }

        @Test
        public void testRefrigeratorSetterPourMilk() {
            refrigerator.setHasWorkToDo(false);

            assertFalse(refrigerator.isHasWorkToDo());
            refrigerator.pourMilk();

            assertTrue(refrigerator.isHasWorkToDo());
        }
    }

    @Nested
    @DisplayName("test order food")
    class TestOrderFood {

        @Test
        public void testFoodOrdered() {
            refrigerator.setHasWorkToDo(true);

            assertEquals("Food has been ordered.", refrigerator.orderFood());
        }

        @Test
        public void testFoodNotOrdered() {
            refrigerator.setHasWorkToDo(false);

            assertEquals("No food has been ordered.", refrigerator.orderFood());
        }
    }
}
