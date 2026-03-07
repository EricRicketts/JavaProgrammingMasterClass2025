package org.example;

public class HighScore {

    public static String displayHighScorePosition(String playerName, int playerRanking) {
        String message = playerName + " managed to get into position " + playerRanking + " on the high score list.";
        return message;
    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore >= 100 && playerScore < 500) {
            return 3;
        } else {
            return 4;
        }
    }
}
