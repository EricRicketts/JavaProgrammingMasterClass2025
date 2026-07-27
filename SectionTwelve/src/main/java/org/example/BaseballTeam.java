package org.example;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getTotalTies() {
        return totalTies;
    }

    public void setTotalTies(int totalTies) {
        this.totalTies = totalTies;
    }

    public List<BaseballPlayer> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(BaseballPlayer player) {
        for (BaseballPlayer currentTeamMember : this.getTeamMembers()) {
            String currentTeamMemberLowerCaseName = currentTeamMember.name().toLowerCase();
            String playerLowerCaseName = player.name().toLowerCase();
            if (currentTeamMemberLowerCaseName.equals(playerLowerCaseName)) return;
        }
        this.teamMembers.add(player);
    }

    public String listTeamMembers() {
        StringBuilder teamList = new StringBuilder();
        teamList.append(this.teamName).append(" Roster:\n");
        for (BaseballPlayer player : this.getTeamMembers()) {
            teamList.append(player.name()).append(" ").append(player.position()).append("\n");
        }
        return teamList.toString();
    }

    public int ranking() {
        return (this.getTotalLosses() * 2) + this.getTotalTies() + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "Lost";
        if (ourScore > theirScore) {
            message = "Won";
            this.setTotalWins(this.getTotalWins() + 1);
        } else if (ourScore == theirScore) {
            message = "Tie";
            this.setTotalTies(this.getTotalTies() + 1);
        } else {
            this.setTotalLosses(this.getTotalLosses() + 1);
        }
        return message;
    }

    @Override
    public String toString() {
        StringBuilder teamRecord = new StringBuilder();
        teamRecord = teamRecord.append(this.getTeamName()).append(": ")
            .append(", ").append("ranking: ").append(this.ranking()).append("\n");
        teamRecord = teamRecord.append("Wins: ").append(this.getTotalWins()).append("\n")
            .append("Losses: ").append(this.getTotalLosses()).append("\n")
            .append("Ties: ").append(this.getTotalTies());

        return teamRecord.toString();
    }
}
