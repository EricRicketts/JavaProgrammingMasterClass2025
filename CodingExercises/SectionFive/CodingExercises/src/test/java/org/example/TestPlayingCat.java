package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayingCat {

    boolean[] isSummerArray = {true, false, false};
    int[] temperatureArray = {10, 36, 35};
    boolean[] expectedArray = {false, false, true};

    @Test
    public void testIsCatPlaying() {
        for (int index = 0; index < isSummerArray.length; index++) {
            boolean result = PlayingCat.isCatPlaying(isSummerArray[index], temperatureArray[index]);
            boolean expected = expectedArray[index];
            assertEquals(expected, result);
        }
    }
}
