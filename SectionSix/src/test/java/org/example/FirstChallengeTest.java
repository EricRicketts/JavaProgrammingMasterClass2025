package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstChallengeTest {

    @Test
    public void testFirstChallenge() {
        char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'Z'};
        String[] expectedResults = new String[]{"Able", "Baker", "Charlie", "Dog", "Easy", "Invalid"};

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            String expected =  expectedResults[i];
            String result = FirstChallengeTraditionalSwitchStatement.natoLettersAndWords(letter);

            Assertions.assertEquals(expected,result);
        }
    }
}
