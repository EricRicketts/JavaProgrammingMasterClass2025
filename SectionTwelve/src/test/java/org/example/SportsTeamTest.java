package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SportsTeamTest {
    // The problem with this implementation is that any kind of player can be added
    // to a sports team.  The way this code is written, a baseball player can be
    // added to a soccer team.
    private SportsTeam phillies, astros, afc;

    @BeforeEach
    public void setUp() {
        phillies = new SportsTeam("Philadelphia Phillies");
        astros = new SportsTeam("Houston Astros");
        afc = new SportsTeam("Adelaide Crows");
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
    public void testListBaseballTeamMembers() {
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

    @Test
    public void testListSoccerTeamMembers() {
        String expected = "Adelaide Crows Team Roster:\n" +
            "[SoccerPlayer[name=Tex Walker, position=Center Half Forward]]";
        var tex = new SoccerPlayer("Tex Walker", "Center Half Forward");
        afc.addTeamMember(tex);
        String result = afc.listTeamMembers();

        assertEquals(expected, result);
    }
}
