package org.example;

public class Scores {

    public static String calculateScore(String playerName, int score) {

        return STR."Player \{playerName} scored \{score} points.";
    }

    public static String calculateScore(int score) {

        // Java does not have an option for default parameters
        // but in this case you can call another method with more parameters
        // and pass in the values which would be default parameters in other
        // languages
        return calculateScore("Anonymous", score);
    }
}
