package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberTypesIntegerTest {

/*
    Primitive Wrapper
    byte      Byte
    int     Integer
    char      Character
    int       Integer
    long      Long
    float     Float
    double    Double
    boolean   Boolean
*/

    int minValueInteger = Integer.MIN_VALUE;
    int maxValueInteger = Integer.MAX_VALUE;
    String minValueIntegerString = Integer.toString(minValueInteger);
    String maxValueIntegerString = Integer.toString(maxValueInteger);
    String expectedIntegerMinValue = "-2147483648";
    String expectedIntegerMaxValue = "2147483647";

    @Test
    void intValueRangeTest() {
        assertEquals(expectedIntegerMinValue, minValueIntegerString);
        assertEquals(expectedIntegerMaxValue, maxValueIntegerString);
    }

    @Test
    void intOverflowTest() {
        int overFlowIntegerMinValue = (Integer.MIN_VALUE - 1); // wraps to 2_147_483_647
        int overFlowIntegerMaxValue = (Integer.MAX_VALUE + 1); // wraps to -2_147_483_648

        String overFlowIntegerMinValueString = Integer.toString(overFlowIntegerMinValue);
        String overFlowIntegerMaxValueString = Integer.toString(overFlowIntegerMaxValue);

        assertEquals(overFlowIntegerMinValueString, expectedIntegerMaxValue);
        assertEquals(overFlowIntegerMaxValueString, expectedIntegerMinValue);
    }

    @Test
    void castingTest() {
        int myMinIntegerValue = Integer.MIN_VALUE;
        int myNewIntegerValue = (myMinIntegerValue / 2);
        assertEquals(-1_073_741_824, myNewIntegerValue);
        // no casting needed as the default whole number type is int
    }
}