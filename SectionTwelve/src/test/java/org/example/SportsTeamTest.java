package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SportsTeamTest {

    private SportsTeam phillies, astros;

    @BeforeEach
    public void setUp() {
        phillies = new SportsTeam("Philadelphia Phillies");
        astros = new SportsTeam("Houston Astros");
    }

    @Test
    public void testPhilliesLoseToAstros() {
        String expected = "Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)";
        String gameResult = phillies.setScore(3, 5);
        String result = phillies.toString() + " " + gameResult + " " + astros.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testPhilliesTieAstros() {
        String expected = "Philadelphia Phillies (Ranked 2) tied Houston Astros (Ranked 1)";
        String gameResult = phillies.setScore(3, 3);
        String result = phillies.toString() + " " + gameResult + " " + astros.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testPhilliesBeatAstros() {
        String expected = "Philadelphia Phillies (Ranked 1) beat Houston Astros (Ranked 1)";
        String gameResult = phillies.setScore(3, 2);
        String result = phillies.toString() + " " + gameResult + " " + astros.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testListTeamMembers() {
        String expected = "Houston Astros Team Roster:\n" +
            "[BaseballPlayer[name=B Harper, position=Right Field], " +
            "BaseballPlayer[name=B Marsh, position=Left Field]]";
        var harper = new BaseballPlayer("B Harper", "Right Field");
        var marsh = new BaseballPlayer("B Marsh", "Left Field");
        astros.addTeamMember(harper);
        astros.addTeamMember(marsh);
        String result = astros.listTeamMembers();

        assertEquals(expected, result);
    }
}
