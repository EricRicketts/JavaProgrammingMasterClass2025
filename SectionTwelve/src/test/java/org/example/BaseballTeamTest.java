package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballTeamTest {

    private BaseballTeam baseballTeam;

    @BeforeEach
    public void setUp() {
        baseballTeam = new BaseballTeam("Houston Astros");
        baseballTeam.addTeamMember(new BaseballPlayer("Lou Gherig", "First Base"));
        baseballTeam.addTeamMember(new BaseballPlayer("Babe Ruth", "Left Field"));
        baseballTeam.addTeamMember(new BaseballPlayer("Willie Mays", "Center Field"));
        baseballTeam.setTotalWins(10);
        baseballTeam.setTotalLosses(4);
        baseballTeam.setTotalTies(1);
    }

    @Nested
    @DisplayName("test baseball team getters")
    class TestBaseballTeamGetters {

        @Test
        public void testBaseballTeamGetTeamName() {
            assertEquals("Houston Astros", baseballTeam.getTeamName());
        }

        @Test
        public void testBaseballTeamGetTeamTotalWins() {
            assertEquals(10, baseballTeam.getTotalWins());
        }

        @Test
        public void testBaseballTeamGetTeamTotalLosses() {
            assertEquals(4, baseballTeam.getTotalLosses());
        }

        @Test
        public void testBaseballTeamGetTeamTotalTies() {
            assertEquals(1, baseballTeam.getTotalTies());
        }

        @Test
        public void testBaseballTeamGetTeamMembers() {
            List<BaseballPlayer> expectedTeamMembers = new ArrayList<>(
                List.of(
                    new BaseballPlayer("Lou Gherig", "First Base"),
                    new BaseballPlayer("Babe Ruth", "Left Field"),
                    new BaseballPlayer("Willie Mays", "Center Field")
                )
            );
            List<BaseballPlayer> currentTeamMembers = baseballTeam.getTeamMembers();

            assertEquals(expectedTeamMembers, currentTeamMembers);
        }
    }

    @Nested
    @DisplayName("test baseball team setters")
    class TestBaseballTeamSetters {

        @Test
        public void testBaseballTeamSetTeamName() {
            assertEquals("Houston Astros", baseballTeam.getTeamName());

            baseballTeam.setTeamName("Los Angeles Dodgers");
            assertEquals("Los Angeles Dodgers", baseballTeam.getTeamName());
        }

        @Test
        public void testBaseballTeamSetTeamTotalWins() {
            assertEquals(10, baseballTeam.getTotalWins());

            baseballTeam.setTotalWins(15);
            assertEquals(15, baseballTeam.getTotalWins());
        }

        @Test
        public void testBaseballTeamSetTeamTotalLosses() {
            assertEquals(4, baseballTeam.getTotalLosses());

            baseballTeam.setTotalLosses(7);
            assertEquals(7, baseballTeam.getTotalLosses());
        }

        @Test
        public void testBaseballTeamSetTeamTotalTies() {
            assertEquals(1, baseballTeam.getTotalTies());

            baseballTeam.setTotalTies(3);
            assertEquals(3, baseballTeam.getTotalTies());
        }
    }

    @Nested
    @DisplayName("test add and list team members")
    class TestAddAndListTeamMembers {

        @Test
        public void testAddTeamMember() {
            BaseballPlayer expectedPlayer = new BaseballPlayer("Hank Aaron", "Right Field");
            assertEquals(3, baseballTeam.getTeamMembers().size());
            baseballTeam.addTeamMember(new BaseballPlayer("Hank Aaron", "Right Field"));

            assertEquals(4, baseballTeam.getTeamMembers().size());
            assertEquals(expectedPlayer, baseballTeam.getTeamMembers().getLast());
        }

        @Test
        public void testListTeamMembers() {
            String expectedTeamMembers = """
                Houston Astros Roster:
                Lou Gherig First Base
                Babe Ruth Left Field
                Willie Mays Center Field
                """;
            String teamMembers = baseballTeam.listTeamMembers();

            assertEquals(expectedTeamMembers, teamMembers);
        }
    }

    @Nested
    @DisplayName("test baseball team ranking and scoring")
    class TestBaseballTeamRankingAndScoring {

        @Test
        public void testBaseballTeamCurrentRanking() {
            assertEquals(10, baseballTeam.ranking());
        }

        @Test
        public void testBaseballRankingChangesAfterScoringLoss() {
            assertEquals(10, baseballTeam.ranking());

            String expected = "Lost";
            String result = baseballTeam.setScore(3, 4);

            assertEquals(expected, result);
            assertEquals(12, baseballTeam.ranking());
        }

        @Test
        public void testBaseballRankingChangesAfterScoringTie() {
            assertEquals(10, baseballTeam.ranking());

            String expected = "Tie";
            String result = baseballTeam.setScore(5, 5);

            assertEquals(expected, result);
            assertEquals(11, baseballTeam.ranking());

        }
    }
}
