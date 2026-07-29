package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnhancedTeamTest {

    // Note, there is no need to exhaustively test the EnhancedTeam class as most of the test are covered
    // in the Team test file.

    private EnhancedTeam enhancedTeam;

    @BeforeEach
    public void setUp() {
        Affiliation affiliation = new Affiliation("Downtown", "Finance", "US");
        enhancedTeam = new EnhancedTeam<Player, Affiliation>("Orlando", affiliation);
        enhancedTeam.setTotalWins(10);
        enhancedTeam.setTotalLosses(5);
        enhancedTeam.setTotalTies(1);
    }

    @Test
    public void testEnhancedTeamToString() {
        String expected = """
            Orlando:
            Affiliation: Downtown (Finance in US)
            Ranking: 12
            Wins: 10
            Losses: 5
            Ties: 1""";
        String result = enhancedTeam.toString();

        assertEquals(expected, result);
    }
}
