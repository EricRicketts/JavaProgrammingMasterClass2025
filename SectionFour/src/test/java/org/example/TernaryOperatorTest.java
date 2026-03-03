package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TernaryOperatorTest {

    String myString = "default";
    int myNumber = 0;

    @Test
    public void testReturnFirstOperatorInTernary() {
        myString = myNumber > -1 ? "Bigger than a negative number" : "Smaller than a positive number";
        Assertions.assertEquals("Bigger than a negative number", myString);
    }

    @Test
    public void testReturnSecondOperatorInTernary() {
        myString = myNumber > 1 ? "Bigger than a negative number" : "Smaller than a positive number";
        Assertions.assertEquals("Smaller than a positive number", myString);
    }
}
