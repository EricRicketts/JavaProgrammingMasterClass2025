package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SectionFiveTestGameCalculateScore {

    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testCalculateScoreGameOver() {
        game.calculateScore(true, 10_000, 8, 200);
        int finalScore = game.getFinalScore();
        Assertions.assertEquals(12_600, finalScore);
    }

    @Test
    public void testCalculateScoreWithVariables() {
       boolean gameOver = true;
       int score = 10_000;
       int levelCompleted = 8;
       int bonus = 200;

       game.calculateScore(gameOver, score, levelCompleted, bonus);
       int finalScore = game.getFinalScore();
       Assertions.assertEquals(12_600, finalScore);
    }

    @Test
    public void testCalculateScoreGameNotOver() {
        game.calculateScore(false, 2_000, 5, 200);
        int finalScore = game.getFinalScore();
        // score initialized to zero this is why it is zero, calculate score only calls
        // setFinalScore when the game is over
        Assertions.assertEquals(0, finalScore);
        Assertions.assertFalse(game.isGameOver());
    }
}
