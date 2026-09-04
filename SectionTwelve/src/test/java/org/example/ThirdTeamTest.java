package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ThirdTeamTest {
    // The problem with this implementation is that any kind of player can be added
    // to a sports SecondTeam.  The way this code is written, a baseball player can be
    // added to a soccer SecondTeam.

    private Affiliation affiliation;
    private ThirdTeam<BaseballPlayer, Affiliation> phillies, astros, yankees, indians;
    private ThirdTeam<SoccerPlayer, Affiliation> afc;
    private ThirdTeam<VolleyballPlayer, Affiliation> abc;
    private List<String> gameResult = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        var affiliation = new Affiliation("Fred", "State", "US");
        phillies = new ThirdTeam<>("Philadelphia Phillies", affiliation);
        astros = new ThirdTeam<>("Houston Astros", affiliation);
        yankees = new ThirdTeam<>("New York Yankees", affiliation);
        indians = new ThirdTeam<>("Cleveland Indians", affiliation);
        afc = new ThirdTeam<>("Adelaide Crows", affiliation);
        abc = new ThirdTeam<>("Detroit Dares", affiliation);
    }

    @Nested
    @DisplayName("test single argument constructor")
    class TestSingleArgumentConstructor {

        @Test
        public void testSingleArgumentConstructor() {
            ThirdTeam<BasketballPlayer, Affiliation> bulls = new ThirdTeam<>("Chicago Bulls");
            assertEquals("Chicago Bulls", bulls.getTeamName());
            assertEquals("generic", bulls.getAffiliation().name());
            assertEquals("unknown", bulls.getAffiliation().type());
            assertEquals("UKWN", bulls.getAffiliation().countryCode());
        }
    }

    @Nested
    @DisplayName("test scoring")
    class TestTeamScoring {
        @Test
        public void testPhilliesLoseToAstros() {
            String expected = "Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)";
            String gameResult = phillies.setScore(phillies, 3, astros, 5);
            String result = phillies.toString() + " " + gameResult + " " + astros.toString();

            assertEquals(expected, result);
        }

        @Test
        public void testPhilliesTieAstros() {
            String expected = "Philadelphia Phillies (Ranked 2) tied Houston Astros (Ranked 2)";
            String gameResult = phillies.setScore(phillies, 3, astros, 3);
            String result = phillies.toString() + " " + gameResult + " " + astros.toString();

            assertEquals(expected, result);
        }

        @Test
        public void testPhilliesBeatAstros() {
            String expected = "Philadelphia Phillies (Ranked 1) beat Houston Astros (Ranked 3)";
            String gameResult = phillies.setScore(phillies, 3, astros, 2);
            String result = phillies.toString() + " " + gameResult + " " + astros.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test list team members")
    class TestListTeamMembers {

        @Test
        public void testListSecondBaseballTeamMembers() {
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
        public void testListSecondSoccerTeamMembers() {
            String expected = "Adelaide Crows Team Roster:\n" +
                "[SoccerPlayer[name=Tex Walker, position=Center Half Forward]]";
            var tex = new SoccerPlayer("Tex Walker", "Center Half Forward");
            afc.addTeamMember(tex);
            //  afc.addSecondTeamMember(new BaseballPlayer("Foo", "Bar"));
            //  The above gives a compiler error because a baseball player cannot be added
            //  to a soccer SecondTeam.
            String result = afc.listTeamMembers();

            assertEquals(expected, result);
        }

        @Test
        public void testListVolleyBallTeamMembers() {
            String expected = "Detroit Dares Team Roster:\n" +
                "[VolleyballPlayer[name=B Black, position=Opposite], " +
                "VolleyballPlayer[name=C Charlie, position=Front]]";
            abc.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
            abc.addTeamMember(new VolleyballPlayer("C Charlie", "Front"));
            String result = abc.listTeamMembers();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test print volleyball team members")
    class TestPrintVolleyballTeamMembers {

        @Test
        public void testPrintVolleyBallTeamMemberNames() {
            String expected = "Team Member Names:\n" +
                "A Adan\n" +
                "B Black\n" +
                "C Charlie";
            abc.addTeamMember(new VolleyballPlayer("A Adan", "Back"));
            abc.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
            abc.addTeamMember(new VolleyballPlayer("C Charlie", "Front"));
            String result = abc.printTeamMemberNames();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test Third Team Getters")
    class TestThirdTeamGetters {

        @BeforeEach
        public void setUp() {
            gameResult.add(phillies.setScore(indians, 3, yankees, 5));
            gameResult.add(phillies.setScore(indians, 2, yankees, 4));
            gameResult.add(phillies.setScore(indians, 0, yankees, 1));

            gameResult.add(phillies.setScore(indians, 2, yankees, 2));

            gameResult.add(phillies.setScore(indians, 2, yankees, 0));
            gameResult.add(phillies.setScore(indians, 1, yankees, 0));
        }

        @Test
        public void testYankeesRecord() {
            assertEquals(3, yankees.getTotalWins());
            assertEquals(1, yankees.getTotalTies());
            assertEquals(2, yankees.getTotalLosses());
        }

        @Test
        public void testIndiansRecord() {
            assertEquals(2, indians.getTotalWins());
            assertEquals(1, indians.getTotalTies());
            assertEquals(3, indians.getTotalLosses());
        }
    }

    @Nested
    @DisplayName("test get team name and team affiliation")
    class TestTeamNameAndAffiliation {

        @Test
        public void testGetTeamName() {
            assertEquals("New York Yankees", yankees.getTeamName());
        }

        @Test
        public void testGetAffiliation() {
            var affiliation = new Affiliation("Fred", "State", "US");
            ThirdTeam<BaseballPlayer, Affiliation> redSox =
                new ThirdTeam<>("Boston Red Sox", affiliation);
            assertEquals("Fred (State in US)", redSox.getAffiliation().toString());
        }
    }
}
