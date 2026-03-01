package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberTypesLongTest {

/*
    Primitive Wrapper
    byte      Byte
    long     Long
    char      Character
    int       Integer
    long      Long
    float     Float
    double    Double
    boolean   Boolean
*/

    long minValueLong = Long.MIN_VALUE;
    long maxValueLong = Long.MAX_VALUE;
    String minValueLongString = Long.toString(minValueLong);
    String maxValueLongString = Long.toString(maxValueLong);
    String expectedLongMinValue = "-9223372036854775808";
    String expectedLongMaxValue = "9223372036854775807";

    @Test
    void longValueRangeTest() {
        assertEquals(expectedLongMinValue, minValueLongString);
        assertEquals(expectedLongMaxValue, maxValueLongString);
    }

    @Test
    void longOverflowTest() {
        long overFlowLongMinValue = (long) (Long.MIN_VALUE - 1); // wraps to LONG.MAX_VALUE
        long overFlowLongMaxValue = (long) (Long.MAX_VALUE + 1); // wraps to LONG.MIN_VALUE

        String overFlowLongMinValueString = Long.toString(overFlowLongMinValue);
        String overFlowLongMaxValueString = Long.toString(overFlowLongMaxValue);

        assertEquals(overFlowLongMinValueString, expectedLongMaxValue);
        assertEquals(overFlowLongMaxValueString, expectedLongMinValue);
    }

    @Test
    void castingTest() {
        long myMinLongValue = Long.MIN_VALUE;
        long myNewLongValue = (long) (myMinLongValue / 2);
        assertEquals(-4_611_686_018_427_387_904L, myNewLongValue);
        // see comment on Byte test
    }
}