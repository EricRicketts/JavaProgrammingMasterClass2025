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
}
