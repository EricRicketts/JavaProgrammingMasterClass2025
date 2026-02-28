package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SectionThreeFirstChallenge {

    @Test
    public void firstChallengeTest() {
        int [] expected = {10, 100};
        int [] result = {0, 0};
        int myFirstNumber = 10;
        result[0] = myFirstNumber;
        myFirstNumber = 100;
        result[1] = myFirstNumber;
        assertArrayEquals(expected, result);
    }
}
