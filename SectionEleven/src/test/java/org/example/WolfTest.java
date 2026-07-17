package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WolfTest {

    private Wolf wolf;
    private String expected, result;

    @BeforeEach
    public void setUp() {
        wolf = new Wolf();
    }

    @Nested
    @DisplayName("test all the basic motion states for a wolf")
    class TestBasicMovementStates {

        @Test
        public void testWolfWalks() {
            expected = "Wolf is now walking.";
            result = wolf.walk();

            assertEquals(expected, result);
        }

        @Test
        public void testWolfLopes() {
            expected = "Wolf is now loping.";
            result = wolf.lope();

            assertEquals(expected, result);
        }

        @Test
        public void testWolfRuns() {
            expected = "Wolf is now running.";
            result = wolf.run();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test move method")
    class TestMoveMethod {

        @Test
        public void testMoveMethod() {
            expected = "Wolf is now on the move.";
            result = wolf.move();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test track method")
    class TestTrackMethod {

        @Test
        public void testTrackMethod() {
            expected = "Wolf has its tracking devices.";
            result = wolf.track();

            assertEquals(expected, result);
        }
    }

}
