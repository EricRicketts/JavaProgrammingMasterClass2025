package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SectionThreeStringTest {

    String myString = "name";

    @Test
    public void StringClassTest() {
        Assertions.assertEquals("String", myString.getClass().getSimpleName());
    }

    @Test
    public void stringConcatenationTest() {
        myString = "String";
        myString = "This is a simple " + myString + ".";
        Assertions.assertEquals("This is a simple String.", myString);
    }

    @Test
    public void unicodeInStringTest() {
        Character dollarSign = '\u0024';
        myString = "I wish I had a " + dollarSign + 1_000_000 + ".";
        String expected = "I wish I had a $1000000.";
        Assertions.assertEquals(expected, myString);
    }

    @Test
    public void concatenateWithIntegerTest() {
        // operation automatically converts integer to String then concatenates
        myString = "50";
        int myInt = 10;
        Assertions.assertEquals("5010", myString + myInt);
    }

    @Test
    public void concatenateWithDecimalTest() {
        myString = "50.5";
        Assertions.assertEquals("50.550.5", myString + 50.5);
        Double myDecimal = Double.valueOf(myString);
        Assertions.assertEquals(101, 2 * myDecimal);
    }
}
