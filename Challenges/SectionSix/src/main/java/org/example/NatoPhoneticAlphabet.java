package org.example;

import java.util.Arrays;

public class NatoPhoneticAlphabet {
    public static final Character[] LETTERS =
            {       'A', 'B', 'C', 'D', 'E',
                    'F', 'G', 'H', 'I', 'J',
                    'K', 'L', 'M', 'N', 'O',
                    'P', 'Q', 'R', 'S', 'T',
                    'U', 'V', 'W', 'X', 'Y', 'Z'
            };

    public static final String[] NATO_LETTERS = {
            "Able", "Baker", "Charlie", "Dog", "Easy",
            "Fox", "George", "How", "Item", "Jig",
            "King", "Love", "Mike", "Nan", "Oboe",
            "Peter", "Queen", "Roger", "Sugar", "Tare",
            "Uncle", "Victor", "William", "X-ray", "Yoke", "Zebra"
    };
    public static String chooseNatoPhoneticLetterViaTraditionalSwitch(char letter) {

        String natoLetter = "";
        switch (letter) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
            case 'F': case 'G': case 'H': case 'I': case 'J':
            case 'K': case 'L': case 'M': case 'N': case 'O':
            case 'P': case 'Q': case 'R': case 'S': case 'T':
            case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z': {
                int index = Arrays.asList(LETTERS).indexOf(letter);
                natoLetter = NATO_LETTERS[index];
                break;
            }
            default: {
                natoLetter = "Invalid Value";
            }
        }
        return natoLetter;
    }
}