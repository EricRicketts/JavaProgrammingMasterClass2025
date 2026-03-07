package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreTest {

    @Test
    public void testHighScore() {
        int[] scores = new int[] {1500, 1000, 500, 100, 25};
        String[] names = new String[] {"Bert", "Bill", "Bob", "Buster", "Bo"};
        String[] expected = new String[] {
            "Bert managed to get into position 1 on the high score list.",
            "Bill managed to get into position 1 on the high score list.",
            "Bob managed to get into position 2 on the high score list.",
            "Buster managed to get into position 3 on the high score list.",
            "Bo managed to get into position 4 on the high score list."
        };
        for (int index = 0; index < scores.length; index += 1) {
            int position = HighScore.calculateHighScorePosition(scores[index]);
            String message = HighScore.displayHighScorePosition(names[index], position);
            assertEquals(expected[index], message);
        }
    }
}
