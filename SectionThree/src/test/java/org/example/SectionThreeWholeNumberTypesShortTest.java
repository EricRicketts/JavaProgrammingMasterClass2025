package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberTypesShortTest {

/*
    Primitive Wrapper
    byte      Byte
    short     Short
    char      Character
    int       Integer
    long      Long
    float     Float
    double    Double
    boolean   Boolean
*/

    short minValueShort = Short.MIN_VALUE;
    short maxValueShort = Short.MAX_VALUE;
    String minValueShortString = Short.toString(minValueShort);
    String maxValueShortString = Short.toString(maxValueShort);
    String expectedShortMinValue = "-32768";
    String expectedShortMaxValue = "32767";

    @Test
    void shortValueRangeTest() {
        assertEquals(expectedShortMinValue, minValueShortString);
        assertEquals(expectedShortMaxValue, maxValueShortString);
    }

    @Test
    void shortOverflowTest() {
        short overFlowShortMinValue = (short) (Short.MIN_VALUE - 1); // wraps to 32_767
        short overFlowShortMaxValue = (short) (Short.MAX_VALUE + 1); // wraps to -32_768

        String overFlowShortMinValueString = Short.toString(overFlowShortMinValue);
        String overFlowShortMaxValueString = Short.toString(overFlowShortMaxValue);

        assertEquals(overFlowShortMinValueString, expectedShortMaxValue);
        assertEquals(overFlowShortMaxValueString, expectedShortMinValue);
    }

    @Test
    void castingTest() {
        short myMinShortValue = Short.MIN_VALUE;
        short myNewShortValue = (short) (myMinShortValue / 2);
        assertEquals(-16_384, myNewShortValue);
        // see comment on Byte test
    }
}