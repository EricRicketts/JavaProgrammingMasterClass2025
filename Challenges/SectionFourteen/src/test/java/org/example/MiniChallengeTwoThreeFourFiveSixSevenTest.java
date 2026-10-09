package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniChallengeTwoThreeFourFiveSixSevenTest {

    public static String everySecondCharacter(UnaryOperator<String> function, String value) {
        return function.apply(value);
    }

    private String sourceString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String expected = "BDFHJLNPRTVXZ";
    private String result;

    private UnaryOperator<String> everySecondLetter;

    @BeforeEach
    public void setUp() {
        everySecondLetter = s -> {
            StringBuilder returnValue = new StringBuilder();
            for (int index = 0; index < s.length(); index+=1) {
                if (index % 2 == 1) {
                    returnValue.append(s.charAt(index));
                }
            }
            return returnValue.toString();
        };
    }

    @Test
    public void testEverySecondLetterMiniChallengeTwo() {
        result = everySecondLetter.apply(sourceString);

        assertEquals(expected, result);
    }

    @Test
    public void testEverySecondLetterMiniChallengeThree() {
        sourceString = "1234567890";
        expected = "24680";
        result = everySecondLetter.apply(sourceString);

        assertEquals(expected, result);
    }

    @Test
    public void testEverySecondLetterMiniChallengeFour() {
        sourceString = "A12BC34E5F";
        expected = "1B3EF";
        result = everySecondCharacter(s -> {
            StringBuilder returnValue = new StringBuilder();
            for (int index = 0; index < s.length(); index+=1) {
                if (index % 2 == 1) {
                    returnValue.append(s.charAt(index));
                }
            }
            return returnValue.toString();
        }, sourceString);

        assertEquals(expected, result);
    }

    @Test
    public void testEverySecondLetterMiniChallengeFive() {
        sourceString = "1234567890";
        expected = "24680";
        UnaryOperator<String> getSecondLetter = s -> {
            StringBuilder returnValue = new StringBuilder();
            for (int index = 0; index < s.length(); index+=1) {
                if (index % 2 == 1) returnValue.append(s.charAt(index));
            }
            return returnValue.toString();
        };
        result = everySecondCharacter(getSecondLetter, sourceString);

        assertEquals(expected, result);
    }

    @Test
    public void testSupplierFunctionalInterfaceMiniChallengeSix() {
        expected = "I Love Java";
        Supplier<String> getString = () -> "I Love Java";

        result = getString.get();

        assertEquals(expected, result);
    }

    @Test
    public void testSupplierFunctionalInterfaceMiniChallengeSeven() {
        expected = "I LOVE JAVA";
        Supplier<String> getString = () -> "I Love Java";

        result = getString.get().toUpperCase();

        assertEquals(expected, result);
    }
}
