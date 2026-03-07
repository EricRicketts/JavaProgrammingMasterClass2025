package org.example;

public class HighScore {

    public static String displayHighScorePosition(String playerName, int playerRanking) {
        String message = playerName + " managed to get into position " + playerRanking + " on the high score list.";
        return message;
    }

    public static int calculateHighScorePosition(int playerScore) {
//      If statement tested in the order seen.  So if the first condition is false, we know the number is < 1000.
//      Likewise, if the second condition fails, we know the number is < 500 and so on.
//      I could have had multiple return statements, but the other stated better coding practice is only to have one
//      return statement.
        int position;
        if (playerScore >= 1000) {
            position = 1;;
        } else if (playerScore >= 500) { // do not need && playerScore < 1000
            position = 2;
        } else if (playerScore >= 100) { // do not need && playerScore < 500
            position = 3;
        } else {
            position = 4;
        }

        return position;
    }
}
