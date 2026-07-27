package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballPlayerTest {

    BaseballPlayer baseballPlayer;

    @BeforeEach()
    public void setUp() {
        baseballPlayer = new BaseballPlayer("Hank Aaron", "Right Field");
    }

    @Test
    public void testGetBaseballPlayerName() {
        assertEquals("Hank Aaron", baseballPlayer.name());
    }

    @Test
    public void testGetBaseballPlayerPosition() {
        assertEquals("Right Field", baseballPlayer.position());
    }
}
