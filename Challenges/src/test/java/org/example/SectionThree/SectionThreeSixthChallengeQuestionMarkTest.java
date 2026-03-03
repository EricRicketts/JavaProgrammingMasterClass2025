package org.example.SectionThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeSixthChallengeQuestionMarkTest {

    @Test
    public void testQuestionMarkCharacter() {
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63;

        Assertions.assertArrayEquals(new char[]{mySimpleChar, mySimpleChar}, new char[]{myUnicodeChar, myDecimalChar});
    }
}
