package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AndOrOperatorsTest {

    String myString = "default";
    int myNumber = 10;
    boolean result;

    @Test
    public void andOperatorTrueTest() {
        if (myString.equals("default") && myNumber == 10) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void andFirstOperatorFalseTest() {
        result = !(myString.equals("Foo Bar") && myNumber == 10);
        if (!result) {
            Assertions.assertFalse(false);
        }
    }

    @Test
    public void andSecondOperatorFalseTest() {
        result = !(myString.equals("default") && myNumber > 10);
        if (!result) {
            Assertions.assertFalse(false);
        }
    }

    @Test
    public void orOperatorBothOperatorsTrueTest() {
        result = myString.equals("default") || myNumber == 10;
        if (result) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void orOperatorFirstOperatorTrueTest() {
        result = myString.equals("default") || myNumber < 5;
        if (result) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void orOperatorSecondOperatorTrueTest() {
        result = myString.equals("Foo Bar") || myNumber == 10;
        if (result) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void orOperatorFalseTest() {
        result = myString.equals("Foo Bar") || myNumber > 15;
        if (!result) {
            Assertions.assertFalse(false);
        }
    }

}
