package org.example;

import org.junit.jupiter.api.BeforeEach;

public class ThirdTeamTest {

    private ThirdTeam<VolleyballPlayer, Affiliation> thirdTeam;

    @BeforeEach
    public void setUp() {
        var philly = new Affiliation("city", "Philadelphia", "US");
        thirdTeam = new ThirdTeam<>("Philadelphia Phillies", philly);
        thirdTeam.addTeamMember(new VolleyballPlayer("Foo", "Front"));
        thirdTeam.addTeamMember(new VolleyballPlayer("Bar", "Middle"));
        thirdTeam.addTeamMember(new VolleyballPlayer("Not", "Back"));
    }



}
