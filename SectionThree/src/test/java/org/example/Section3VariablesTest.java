package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Section3VariablesTest {

    int myFirstNumber = (10 + 5) + (2 * 10);
    int mySecondNumber = 12;
    int myThirdNumber = 6;
    int result, expected;

    @Test
    void simpleVariableTest() {
        int x = 3;
        int y = 4;
        result = x + y;
        expected = 7;

        assertEquals(expected, result);
    }

    @Test
    void firstChallengeTest() {
        result = myFirstNumber + mySecondNumber + myThirdNumber;
        expected = 53;

        assertEquals(expected, result);
    }

    @Test
    void secondChallengeTest() {
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        int myLastOne = 1000 -  myTotal;
        expected = 947;

        assertEquals(expected, myLastOne);
    }
}