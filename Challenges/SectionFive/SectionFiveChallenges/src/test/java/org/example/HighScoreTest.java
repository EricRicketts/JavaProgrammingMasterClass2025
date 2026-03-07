package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreTest {

    String[] names, expected;
    String message;
    int[] scores;
    int position;

    @Test
    public void testHighScore() {
        scores = new int[] {1500, 1000, 500, 100, 25};
        names = new String[] {"Bert", "Bill", "Bob", "Buster", "Bo"};
        expected = new String[] {
            "Bert managed to get into position 1 on the high score list.",
            "Bill managed to get into position 1 on the high score list.",
            "Bob managed to get into position 2 on the high score list.",
            "Buster managed to get into position 3 on the high score list.",
            "Bo managed to get into position 4 on the high score list."
        };
        for (int index = 0; index < scores.length; index += 1) {
            position = HighScore.calculateHighScorePosition(scores[index]);
            message = HighScore.displayHighScorePosition(names[index], position);
            assertEquals(expected[index], message);
        }
    }

    @Test
    public void testHighScoreWithOtherBoundaryConditions() {
        scores = new int[] {999, 499, 99};
        names = new String[] {"Charles", "Chuck", "Cody"};
        expected = new String[] {
            "Charles managed to get into position 2 on the high score list.",
            "Chuck managed to get into position 3 on the high score list.",
            "Cody managed to get into position 4 on the high score list."
        };
        for (int index = 0; index < scores.length; index += 1) {
            position = HighScore.calculateHighScorePosition(scores[index]);
            message = HighScore.displayHighScorePosition(names[index], position);
            assertEquals(expected[index], message);
        }
    }
}
