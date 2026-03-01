package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberDataTypeWidthsTest {

    int byteWidth = Byte.SIZE;
    int shortWidth = Short.SIZE;
    int intWidth = Integer.SIZE;
    int longWidth = Long.SIZE;

    int expectedByteWidth = 8;
    int expectedShortWidth = 16;
    int expectedIntWidth = 32;
    int expectedLongWidth = 64;

    @Test
    public void byteWidthTest() {
        assertEquals(expectedByteWidth, byteWidth);
    }

    @Test
    public void shortWidthTest() {
        assertEquals(expectedShortWidth, shortWidth);
    }

    @Test
    public void intWidthTest() {
        assertEquals(expectedIntWidth, intWidth);
    }

    @Test
    public void longWidthTest() {
        assertEquals(expectedLongWidth, longWidth);
    }
}
