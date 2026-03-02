package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeCharAndBooleanTest {

    char myChar;
    Boolean myBoolean;
    String myString;

    @Test
    public void simpleCharTest() {
        // char types can only hold one and only one character
        // we cannot test for a primitive data type so we have
        // to cast to a closely associated class.
        myChar = 'a';
        Character expectedChar = (Character) myChar;

        String derivedClass = expectedChar.getClass().getSimpleName();
        Assertions.assertEquals("Character", derivedClass);
    }

    @Test
    public void unicodeCharTest() {
        // this is the unicode representation
        Character myChar = '\u0044';
        Character expectedChar = 68; // HTML representation is &#68, this is what we would use in HTML
        // we can get more information on the character in the character chart the author uses
        // https://symbl.cc/en
        Assertions.assertEquals('D', myChar);
        Assertions.assertEquals('D', expectedChar);
    }

    @Test
    public void secondUnicodeCharacterTest() {
        char myChar = '\u0021';
        char expectedChar = 33; // as above we can assign a numeric literal to a char or Character variable
        Assertions.assertEquals('!', myChar);
        Assertions.assertEquals('!', expectedChar);
    }

    @Test
    public void booleanTest() {
        myBoolean = true;
        Assertions.assertEquals("Boolean", myBoolean.getClass().getSimpleName());
    }

    @Test
    public void secondBooleanTest() {
        myBoolean = false;
        Assertions.assertEquals("false", myBoolean.toString());
    }

    @Test
    public void characterChallengeTest() {
        // store the three different character values for the question mark: character, unicode,
        // and integer value
        Character mySimpleChar = '?';
        Character myUnicodeChar = '\u003F'; // 48 + 15 = 63
        Character myDecimalChar = 63;

        Assertions.assertTrue(
                (myDecimalChar == myUnicodeChar) && (myUnicodeChar == mySimpleChar)
        );
    }

    @Test
    public void concatCharactersTest() {
        char myFirstChar = 'a'; // \u0061 or 97
        char mySecondChar = 'b'; // \u0062 or 98
        char myThirdChar = 'Ã'; // this is a tilde over a capital A which is the result of summing the unicodes
        int myThirdCharInteger = (myFirstChar + mySecondChar); // sum is \u00C3
        Assertions.assertEquals(195, myThirdCharInteger);
        Assertions.assertEquals(myThirdChar, myFirstChar + mySecondChar);
        Assertions.assertEquals(myThirdChar, '\u0061' + '\u0062');
    }
}
