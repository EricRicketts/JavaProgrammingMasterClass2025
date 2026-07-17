package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EagleTest {

    private Eagle eagle;

    private String expected, result;

    @BeforeEach
    public void setUp() {
        eagle = new Eagle();
    }

    @Nested
    @DisplayName("test eagle basic actions, take off, fly, and land")
    class TestEagleBasicActions {

        @Test
        public void testEagleTakesOff() {
            expected = "Eagle takes off from its nest in the mountains.";
            result = eagle.takeOff();

            assertEquals(expected, result);
        }

        @Test
        public void testEagleFlies() {
            expected = "Eagle does not fly it soars.";
            result = eagle.fly();

            assertEquals(expected, result);
        }

        @Test
        public void testEagleLands() {
            expected = "Eagle lands in its nest in the mountains.";
            result = eagle.land();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test eagle moves")
    class TestEagleMoves {

        @Test
        public void testEagleMoves() {
            expected = "Eagle preferred motion type is flight.";
            result = eagle.move();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test eagle is being tracked")
    class TestEagleTracked {

        @Test
        public void testEagleTracked() {
            expected = "Eagle is being tracked to learn its habits.";
            result = eagle.track();

            assertEquals(expected, result);
        }
    }
}
