package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {

    Team<BaseballPlayer> baseballTeam;
    Team<SoccerPlayer> soccerTeam;
    List<BaseballPlayer> baseballPlayers;
    List<SoccerPlayer> soccerPlayers;

    @BeforeEach
    public void setUp() {
        // First, define some players for both the baseball and soccer teams.
        String[] baseballPlayerNames = new String[]{"Babe Ruth", "Lou Gherig", "Joe DiMaggio"};
        String[] baseballPlayerPositions = new String[]{"Left Field", "First Base", "Center Field"};
        String[] soccerPlayerNames = new String[]{"Lionel Messi", "Cristiano Ronaldo", "Diego Maradona"};
        String[] soccerPlayerPositions = new String[]{"Right Wing", "Center Forward", "Attacking Midfield"};

        baseballTeam = new Team<BaseballPlayer>("New York Yankees");
        soccerTeam = new Team<SoccerPlayer>("Manchester United");

        baseballPlayers = new ArrayList<>();
        soccerPlayers = new ArrayList<>();

        for (int index = 0; index < 3; index++) {
            String currentBaseballPlayerName = baseballPlayerNames[index];
            String currentBaseballPlayerPosition = baseballPlayerPositions[index];
            String currentSoccerPlayerName = soccerPlayerNames[index];
            String currentSoccerPlayerPosition = soccerPlayerPositions[index];

            BaseballPlayer currentBaseballPlayer = new BaseballPlayer(
                currentBaseballPlayerName, currentBaseballPlayerPosition
            );

            SoccerPlayer currentSoccerPlayer = new SoccerPlayer(
                currentSoccerPlayerName, currentSoccerPlayerPosition
            );

            baseballTeam.addTeamMember(currentBaseballPlayer);
            soccerTeam.addTeamMember(currentSoccerPlayer);
            baseballPlayers.add(currentBaseballPlayer);
            soccerPlayers.add(currentSoccerPlayer);
        }

        baseballTeam.setTotalWins(10);
        baseballTeam.setTotalLosses(5);
        baseballTeam.setTotalTies(1);

        soccerTeam.setTotalWins(20);
        soccerTeam.setTotalLosses(10);
        soccerTeam.setTotalTies(2);

    }

    @Nested
    @DisplayName("test getters for baseball team")
    class TestGettersForBaseballTeam {

        @Test
        public void testTeamNameGetterForBaseballTeam() {
            assertEquals("New York Yankees", baseballTeam.getTeamName());
        }

        @Test
        public void testTeamTotalWinsGetterForBaseballTeam() {
            assertEquals(10, baseballTeam.getTotalWins());
        }

        @Test
        public void testTeamTotalLossesGetterForBaseballTeam() {
            assertEquals(5, baseballTeam.getTotalLosses());
        }

        @Test
        public void testTeamTotalTiesGetterForBaseballTeam() {
            assertEquals(1, baseballTeam.getTotalTies());
        }

        @Test
        public void testTeamMembersGetterForBaseballTeam() {
            assertEquals(baseballPlayers, baseballTeam.getTeamMembers());
        }
    }

    @Nested
    @DisplayName("test setters for baseball team")
    class TestSettersForBaseballTeam {

        @Test
        public void testTeamNameSetterForBaseballTeam() {
            assertEquals("New York Yankees", baseballTeam.getTeamName());
            baseballTeam.setTeamName("Houston Astros");

            assertEquals("Houston Astros", baseballTeam.getTeamName());
        }

        @Test
        public void testTeamTotalWinsSetterForBaseballTeam() {
            assertEquals(10, baseballTeam.getTotalWins());
            baseballTeam.setTotalWins(15);

            assertEquals(15, baseballTeam.getTotalWins());
        }

        @Test
        public void testTeamTotalLossesSetterForBaseballTeam() {
            assertEquals(5, baseballTeam.getTotalLosses());
            baseballTeam.setTotalLosses(10);

            assertEquals(10, baseballTeam.getTotalLosses());
        }

        @Test
        public void testTeamTotalTiesSetterForBaseballTeam() {
            assertEquals(1, baseballTeam.getTotalTies());
            baseballTeam.setTotalTies(2);

            assertEquals(2, baseballTeam.getTotalTies());
        }
    }
}
