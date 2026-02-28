package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SectionThreeFirstChallengeTest {

    @Test
    public void firstChallengeTest() {
        int [] expected = {10, 1000};
        int [] result = {0, 0};
        int myFirstNumber = 10;
        result[0] = myFirstNumber;
        myFirstNumber = 1000;
        result[1] = myFirstNumber;
        assertArrayEquals(expected, result);
    }
}
