package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoccerPlayerTest {

    private SoccerPlayer soccerPlayer;

    @BeforeEach
    public void setUp() {
        soccerPlayer = new SoccerPlayer("Christiano Ronaldo", "Forward");
    }

    @Nested
    @DisplayName("test name and position getters")
    class TestNameAndPositionGetters {

        @Test
        public void testNameGetter() {
            assertEquals("Christiano Ronaldo", soccerPlayer.name());
        }

        @Test
        public void testPositionGetter() {
            assertEquals("Forward", soccerPlayer.position());
        }
    }

    @Nested
    @DisplayName("test toString")
    class TestToString {

        @Test
        public void testToString() {
            String expected = "SoccerPlayer[name=Christiano Ronaldo, position=Forward]";

            assertEquals(expected, soccerPlayer.toString());
        }
    }

}
