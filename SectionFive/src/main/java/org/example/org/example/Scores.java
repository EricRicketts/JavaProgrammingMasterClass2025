package org.example;

public class Scores {

    public static String calculateScore(String playerName, int score) {

        return STR."Player \{playerName} scored \{score} points.";
    }

    public static String calculateScore(int score) {

        return STR."Unnamed Player scored \{score} points.";
    }
}
