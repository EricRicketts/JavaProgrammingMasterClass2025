package org.example;

public class MethodOverloading {

    public static String calculateScore(String playerName, int score) {
        int newScore = score * 1000;
        return "Player " + playerName + " scored " + newScore + " points.";
    }

    public static String calculateScore(int score) {
        return calculateScore("Unknown Player", score);
    }

    public static String calculateScore() {
        return "No player name, no player score.";
    }
}
/*
    below are valid overloaded methods note the method signatures are all different:
    method names must be same but the parameters are of different type if they
    are the same number.  One can also have a different number of parameters.
    public static void doSomething(int parameter) {}
    public static void doSomething(float parameter) {}
    public static void doSomething(int parameterA, float parameterB) {}
    public static void doSomething(float parameterA, int parameterB) {}
    public static void doSomething(int parameterA, int parameterB, float parameterC) {}
*/
