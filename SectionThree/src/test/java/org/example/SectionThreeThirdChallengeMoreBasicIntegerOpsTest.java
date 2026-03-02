package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeThirdChallengeMoreBasicIntegerOpsTest {

    @Test
    public void thirdChallengeTest() {
        int myFirstNumber = (10 + 5) + (2 * 10);
        int mySecondNumber = 12;
        int myThirdNumber = 2 * myFirstNumber;
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        int myLastOne = 1000 - myTotal;
        int expected = 883;

        assertEquals(expected, myLastOne);
    }
}
