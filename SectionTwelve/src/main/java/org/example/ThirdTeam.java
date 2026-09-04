package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThirdTeam<T extends Player, S> {

    private final String teamName;
    private final List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private final Affiliation affiliation;

    public ThirdTeam(String teamName) {
        this.teamName = teamName;
        this.affiliation = new Affiliation("generic", "unknown", "UKWN");
    }

    public ThirdTeam(String teamName, Affiliation affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {
        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public String listTeamMembers() {
        return teamName + " Team Roster:\n" + teamMembers.toString();
    }

    public String printTeamMemberNames() {
        StringBuilder names = new StringBuilder();
        names.append("Team Member Names:").append("\n");
        for (var member : teamMembers) {
            names.append(member.name()).append("\n");
        }
        return names.toString().stripTrailing();
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(
            ThirdTeam<BaseballPlayer, Affiliation>
                team,
                int score,
                ThirdTeam<BaseballPlayer, Affiliation> other,
                int otherScore
    ) {
        String message = "lost to";
        if (score > otherScore) {
            team.setTotalWins(team.getTotalWins() + 1);
            other.setTotalLosses(other.getTotalLosses() + 1);
            message = "beat";
        } else if (score == otherScore) {
            team.setTotalTies(team.getTotalTies() + 1);
            other.setTotalTies(other.getTotalTies() + 1);
            message = "tied";
        } else {
            team.setTotalLosses(team.getTotalLosses() + 1);
            other.setTotalWins(other.getTotalWins() + 1);
        }
        return message;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getTotalTies() {
        return totalTies;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public void setTotalTies(int totalTies) {
        this.totalTies = totalTies;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
