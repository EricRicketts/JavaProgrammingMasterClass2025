package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SectionThreeFirstChallengePrimitiveTypesTest {

    byte myByte = (byte) 125;
    short myShort = (short) 32_760;
    int myInt = 2_100_000_000;

    long firstLong = (long) (myByte + myShort + myInt);
    long myLong = (long) (10 * firstLong + 50000);
    long expectedLong = 21_000_378_850L;

    @Test
    public void byteDataTypeTest() {
        assertArrayEquals(new byte[]{125}, new byte[]{myByte});
    }

    @Test
    public void shortDataTypeTest() {
        assertArrayEquals(new short[]{32_760}, new short[]{myShort});
    }

    @Test
    public void intDataTypeTest() {
        assertArrayEquals(new int[]{2_100_000_000}, new int[]{myInt});
    }

    @Test
    public void longDataTypeTest() {
        assertArrayEquals(new long[]{expectedLong}, new long[]{myLong});
    }
}
