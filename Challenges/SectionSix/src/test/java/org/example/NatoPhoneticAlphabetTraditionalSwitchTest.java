package org.example;

import org.junit.jupiter.api.Test;

import static org.example.NatoPhoneticAlphabet.LETTERS;
import static org.example.NatoPhoneticAlphabet.NATO_LETTERS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NatoPhoneticAlphabetTraditionalSwitchTest {

    @Test
    public void testChooseNatoPhoneticLetterViaTraditionalSwitch() {
        for (int index = 0; index < 26; index++) {
            char currentLetter = LETTERS[index];
            String expectedNatoLetter = NATO_LETTERS[index];
            String resultantNatoLetter =
                    NatoPhoneticAlphabet.chooseNatoPhoneticLetterViaTraditionalSwitch(currentLetter);
            assertEquals(expectedNatoLetter, resultantNatoLetter);
        }
    }

    @Test
    public void testInvalidInputHandling() {
        char invalidLetter = '!';
        String expectedResult = "Invalid Value";
        String result =
                NatoPhoneticAlphabet.chooseNatoPhoneticLetterViaTraditionalSwitch(invalidLetter);
        assertEquals(expectedResult, result);
    }

}