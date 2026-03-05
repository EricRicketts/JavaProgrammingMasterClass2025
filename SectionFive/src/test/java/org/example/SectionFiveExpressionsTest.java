package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveExpressionsTest {

    /*
        Expression is kmToMiles = (100 * 1.609344)
        Statement is completed by adding the "double" and ";"
        An expression resolves to a value, a statement is a complete unit of execution that performs an action.
    */
    double kmToMiles = (100 * 1.609344);
    int highScore;;
    int health;

    @Test
    public void testHighScore() {
        /*
            There are four expressions here, (1)highScore = 50; if (2)(highScore > 25); (3) 1000 + highScore
            (4) highScore = 1000 + highScore;
        */
        highScore = 50;
        if (highScore > 25) {
            highScore = 1000 + highScore;
        }
        Assertions.assertEquals(1050, highScore);
    }

    @Test
    public void testHealth() {
        health = 20;
        highScore = 2000;
        if ((health < 25) && (highScore > 1000)) {
            highScore = highScore - 1000;
        }
        Assertions.assertEquals(1000, highScore);
    }
}
/*
    Identify all the expressions in the following code:

    int health = 100; => health = 100

    if ((health < 25) && (highScore > 1000)) { => health < 25; highScore > 1000; the entire conditional
        highScore = highScore - 1000;          => highScore - 100; highScore = highScore - 100
    }
    so there are 6 expressions this answer was validated by the instructor
*/
