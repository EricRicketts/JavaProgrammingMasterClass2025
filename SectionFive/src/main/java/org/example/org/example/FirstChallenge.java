package org.example;

public class FirstChallenge {

    public String displayHighScorePosition(String name, int position) {
        return StringTemplate.STR."\{name} managed to get into position \{position} on the high score list.";
    }

    public int calculateHighScorePosition(int score) {
        int position;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2; 
        } else if (score >= 100) {
            position = 3; 
        } else {
            position = 4;
        }
        
        return position;
    }

}
