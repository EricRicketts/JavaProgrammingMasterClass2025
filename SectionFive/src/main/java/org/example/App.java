package org.example;

public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int calculateScore(int score, boolean gameOver) {
        int levelCompleted = 8;
        int bonus = 200;
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
        }

        return finalScore;
    }

    public int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }

        return finalScore;
    }
}
