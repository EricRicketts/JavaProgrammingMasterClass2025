package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeSeventhChallengeDecrementTest {

    @Test
    public void decrementChallengeTest() {
        int result = 10;
        result -= 5;
        Assertions.assertEquals(5, result);
    }
}
