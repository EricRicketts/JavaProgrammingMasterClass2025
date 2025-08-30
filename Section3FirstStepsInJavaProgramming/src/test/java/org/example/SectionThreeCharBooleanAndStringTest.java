package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeCharBooleanAndStringTest {

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
        myChar = '\u0044';
        Character expectedChar = 68; // HTML representation is &#68, this is what we would use in HTML
        // we can get more information on the character in the character chart the author uses
        // https://symbl.cc/en
        Assertions.assertEquals('D', myChar);
        Assertions.assertEquals('D', expectedChar);
    }

    @Test
    public void booleanTest() {
        myBoolean = true;
        Assertions.assertEquals("Boolean", myBoolean.getClass().getSimpleName());
    }

    @Test
    public void stringTest() {
        myString = "String";
        Assertions.assertEquals("String", myString.getClass().getSimpleName());
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
    public void secondStringTest() {
        myString = "String";
        String myNewString = "This is a simple " + myString + ".";
        Assertions.assertEquals("This is a simple String.", myNewString);
    }

    @Test
    public void usingUnicodeInStringsTest() {
        Character dollarSign = '\u0024';
        String statement = "I wish I had a " + dollarSign + "1,000,000.";
        String expected = "I wish I had a $1,000,000.";
        Assertions.assertEquals(expected, statement);
    }

    @Test
    public void usingStringsAndNumbersTest() {
        // Strings are immutable in Java the String concatenation operator "+"
        // creates a new String.  More to come on strings later in the course.

        myString = "50.5" + 50.5;
        String expected = "50.550.5";
        Double mySum = Double.valueOf("50.5"); // argument must be string could not do something
        // like Double.valueOf("50.5" + 50.5)
        Assertions.assertEquals(expected, myString);
        Assertions.assertEquals(101, mySum + 50.5);
    }

    @Test
    public void modulusOperatorTest() {
        Assertions.assertEquals(2, 5 % 3);
    }

    @Test
    public void concatCharactersTest() {
        char myFirstChar = 'a'; // \u0061 or 97
        char mySecondChar = 'b'; // \u0062 or 98
        int myThirdChar = (myFirstChar + mySecondChar); // sum is \u00C3
        Assertions.assertEquals(195, myFirstChar + mySecondChar);
    }

    @Test
    public void compoundAssignmentTest() {
        int result = 10;
        int secondResult = 10;
        result += 5;
        secondResult -= 5;
        Assertions.assertEquals(15, result);
        Assertions.assertEquals(5, secondResult);
    }

    @Test
    public void postIncrementOperatorTest() {
        int result = 10;
        result++;
        Assertions.assertEquals(11, result);
    }

    @Test
    public void postDecrementOperatorTest() {
        int result = 10;
        result--;
        Assertions.assertEquals(9, result);
    }

    @Test
    public void compoundAssignmentQuirkTest() {
        int result = 10;
        result -= 5.5;
        // result = result - 5.5, an implicit cast occurs to guard against errors but
        // unexpected results may occur it is really => result = (data type of result) (result - 5.5)
        // since the cast is an int then (result - 5.5) = 4.5 which is truncated to 4
        Assertions.assertEquals(4, result);
    }

    @Test
    public void postMultiplicativeCompoundOperatorTest() {
        int result = 10;
        result *= 2;
        Assertions.assertEquals(20, result);
    }

    @Test
    public void postDivideCompoundOperatorTest() {
        int result = 10;
        result /= 2;
        Assertions.assertEquals(5, result);
    }
}
