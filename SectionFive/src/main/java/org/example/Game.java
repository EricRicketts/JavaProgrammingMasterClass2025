package org.example;

public class Game {

    private boolean gameOver;
    private int score;
    private int finalScore;
    private int levelCompleted;
    private int bonus;

    public Game() {
        this.gameOver = false;
        this.score = 0;
        this.finalScore = 0;
        this.levelCompleted = 0;
        this.bonus = 0;
    }

    public int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        this.setGameOver(gameOver);
        this.setScore(score);
        this.setLevelCompleted(levelCompleted);
        this.setBonus(bonus);

        if (gameOver) {
            this.setFinalScore();
            return this.getFinalScore();
        } else {
            return this.getScore();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore() {
        this.finalScore = this.getScore() + this.getLevelCompleted() * this.getBonus() + 1000;
    }

    public int getLevelCompleted() {
        return levelCompleted;
    }

    public void setLevelCompleted(int levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
