package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionThreeVariablesTest {

    int myFirstNumber = (10 + 5) + (2 * 10);
    int mySecondNumber = 12;
    int myThirdNumber = 6;
    int result, expected;

    @Test
    void simpleVariableTest() {
        int x = 3;
        int y = 4;
        int z = 5; // variable declaration, variable type and variable name, we do an assignment here
        // but this is not required.  When we have a variable declaration with the variable being assigned a value,
        // this is called an expression.
        int resultSumXAndY = x + y;
        int resultSumXYAndZ = x + y + z;
        int expectedSumXAndY = 7;
        int expectedSumXYAndZ = 12;

        assertEquals(expectedSumXAndY, resultSumXAndY);
        assertEquals(expectedSumXYAndZ, resultSumXYAndZ);
        assertEquals(z, resultSumXYAndZ - resultSumXAndY);
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

    @Test
    void gitTest() {
        int myGitTest = 10;
        assertEquals(10, myGitTest);
    }
}