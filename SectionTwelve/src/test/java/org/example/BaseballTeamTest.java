package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTeamTest {

    private BaseballTeam phillies, astros;

    @BeforeEach
    public void setUp() {
        phillies = new BaseballTeam("Philadelphia Phillies");
        astros = new BaseballTeam("Houston Astros");
    }

    @Test
    public void testPhilliesLoseToAstros() {
        String expected = "Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)";
        String gameResult = phillies.setScore(3, 5);
        String result = phillies.toString() + " " + gameResult + " " + astros.toString();

        assertEquals(expected, result);
    }
}
