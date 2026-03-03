package org.example.SectionFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorChallenge {

    @Test
     public void testSectionFourOperatorChallenge () {
        double myDouble = 20.00;
        double mySecondDouble = 80.00;
        double myTotal = (myDouble + mySecondDouble) * 100;
        String output = "default";

        Assertions.assertEquals(10000.00, myTotal);

        double myRemainder = myTotal % 40.00;
        Assertions.assertEquals(0.00, myRemainder);
        boolean isRemainderZero = myTotal % 40.00 == 0 ? true : false;
        Assertions.assertTrue(isRemainderZero);

        if (!isRemainderZero) {
            output = "Got some remainder";
        }
        Assertions.assertNotEquals("Got some remainder", output);
    }
}
