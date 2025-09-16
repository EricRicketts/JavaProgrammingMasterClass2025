package org.example;

public class FirstChallengeTraditionalSwitchStatement {

    public static String natoLettersAndWords(char letter) {
        String chosenWord;
        switch (letter) {
            case 'A': {
                chosenWord = "Able";
                break;
            }
            case 'B': {
                chosenWord = "Baker";
                break;
            }
            case 'C': {
                chosenWord = "Charlie";
                break;
            }
            case 'D': {
                chosenWord = "Dog";
                break;
            }
            case 'E': {
                chosenWord = "Easy";
                break;
            }
            default: {
                chosenWord = "Invalid";
                break;
            }
        }
        return chosenWord;
    }
}
