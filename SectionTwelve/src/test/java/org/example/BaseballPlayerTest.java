package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballPlayerTest {

    private BaseballPlayer baseballPlayer;

    @BeforeEach
    public void setUp() {
        baseballPlayer = new BaseballPlayer("Fred", "Left Field");
    }

    @Nested
    @DisplayName("test name and position getters")
    class TestNameAndPositionGetters {

        @Test
        public void testNameGetter() {
            assertEquals("Fred", baseballPlayer.name());
        }

        @Test
        public void testPositionGetter() {
            assertEquals("Left Field", baseballPlayer.position());
        }
    }

    @Nested
    @DisplayName("test toString")
    class TestToString {

        @Test
        public void testToString() {
            String expected = "The Player name is: Fred, the Player position is: Left Field";

            assertEquals(expected, baseballPlayer.toString());
        }
    }

}
