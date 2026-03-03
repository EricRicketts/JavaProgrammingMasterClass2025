package org.example.SectionThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeSecondChallengeBasicIntergerOpsTest {

    @Test
    public void secondChallengeTest() {
        int myFirstNumber = (10 + 5) + (2 * 10);
        int mySecondNumber = 12;
        int myThirdNumber = 6;
        int sumOfAllNumbers = myFirstNumber + mySecondNumber + myThirdNumber;

        assertEquals(35, myFirstNumber);
        assertEquals(53, sumOfAllNumbers);
        assertEquals(mySecondNumber, sumOfAllNumbers - myFirstNumber - myThirdNumber);
        assertEquals(myThirdNumber, sumOfAllNumbers - myFirstNumber - mySecondNumber);
    }
}
