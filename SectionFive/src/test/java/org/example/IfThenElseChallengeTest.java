package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IfThenElseChallengeTest {

    boolean gameOver = true;
    int score = 800;
    int levelCompleted = 5;
    int bonus = 100;
    int finalScore = score;

    @Test
    public void testInitialIf() {
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            Assertions.assertEquals(1300, finalScore);
        }
    }

    @Test
    public void testChallenge() {
        score = 10_000;
        finalScore = score;
        levelCompleted = 8;
        bonus = 200;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            Assertions.assertEquals(11_600, finalScore);
        }
    }
}
