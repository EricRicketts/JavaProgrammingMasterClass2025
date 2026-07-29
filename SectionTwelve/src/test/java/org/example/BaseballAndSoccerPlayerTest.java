package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballAndSoccerPlayerTest {

    BaseballPlayer baseballPlayer;
    SoccerPlayer soccerPlayer;

    @BeforeEach()
    public void setUp() {
        baseballPlayer = new BaseballPlayer("Hank Aaron", "Right Field");
        soccerPlayer = new SoccerPlayer("Lionel Messi", "Forward Center");
    }

    @Test
    public void testGetBaseballPlayerName() {
        assertEquals("Hank Aaron", baseballPlayer.name());
    }

    @Test
    public void testGetBaseballPlayerPosition() {
        assertEquals("Right Field", baseballPlayer.position());
    }

    @Test
    public void testGetSoccerPlayerName() {
        assertEquals("Lionel Messi", soccerPlayer.name());
    }

    @Test
    public void testGetSoccerPlayerPosition() {
        assertEquals("Forward Center", soccerPlayer.position());
    }
}
