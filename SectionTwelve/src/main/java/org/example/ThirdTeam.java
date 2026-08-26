package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThirdTeam<T extends Player, S> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public ThirdTeam(String teamName) {
        this.teamName = teamName;
    }

    public ThirdTeam(String teamName, S affiliation) {
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

    public String listTeamMembersAndAffiliation() {
        String affiliationString = affiliation == null ? "" : "AFFILIATION: " + affiliation;
        StringBuilder sb = new StringBuilder();
        sb.append(teamName).append(" ").append("Roster:").append("\n");
        sb.append(affiliationString);
        for (var member : teamMembers) {
            sb.append(member.name()).append("\n");
        }
        return sb.toString().stripTrailing();
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

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    public S getAffiliation() {
        return affiliation;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
