package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeCharBooleanAndStringTest {

    char myChar;
    boolean myBoolean;
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
        myChar = '\u0044';
        Assertions.assertEquals('D', myChar);
    }
}
