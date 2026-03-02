package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeFourthChallengeCastFloatTest {

    @Test
    public void testFloatCast() {
        float myFloat = (float) 5.25;
        float expected = 5.25F;
        Assertions.assertEquals(expected, myFloat);
    }
}