package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberTypesTest {

    int minValueInteger = Integer.MIN_VALUE;
    int maxValueInteger = Integer.MAX_VALUE;
    String minValueString = Integer.toString(minValueInteger);
    String maxValueString = Integer.toString(maxValueInteger);
    String expectedIntegerMinValue = "-2147483648";
    String expectedIntegerMaxValue = "2147483647";
    String expectedByteMinValue = "-128";
    String expectedByteMaxValue = "127";

    @Test
    void integerRangesAndWrappersTest() {
        assertEquals(expectedIntegerMinValue, minValueString);
        assertEquals(expectedIntegerMaxValue, maxValueString);
    }

    @Test
    void integerOverflowTest() {
        int overFlowIntegerMaxValue = maxValueInteger + 1;
        int overFlowIntegerMinValue = minValueInteger - 1;
        String overFlowIntegerMaxValueString  = Integer.toString(overFlowIntegerMaxValue);
        String overFlowIntegerMinValueString = Integer.toString(overFlowIntegerMinValue);

        assertEquals(overFlowIntegerMaxValueString, expectedIntegerMinValue);
        assertEquals(overFlowIntegerMinValueString, expectedIntegerMaxValue);
    }

    @Test
    void byteValueRangeTest() {
        assertEquals(expectedByteMinValue, Integer.toString(Byte.MIN_VALUE));
        assertEquals(expectedByteMaxValue, Integer.toString(Byte.MAX_VALUE));
    }

    @Test
    void byteOverflowTest() {
        byte overFlowByteMinValue = (byte) (Byte.MIN_VALUE - 1);
        byte overFlowByteMaxValue = (byte) (Byte.MAX_VALUE + 1);

        String overFlowByteMinValueString = Byte.toString(overFlowByteMinValue);
        String overFlowByteMaxValueString = Byte.toString(overFlowByteMaxValue);

        assertEquals(overFlowByteMinValueString, expectedByteMaxValue);
        assertEquals(overFlowByteMaxValueString, expectedByteMinValue);
    }

    @Test
    void castingTest() {
        byte myMinByteValue = Byte.MIN_VALUE;
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        // byte myNewByteValue = (myMinByteValue / 2); this statement will cause an error and not compile
        // the error without casting says Incompatible types. Found 'int', required 'byte'
        // in the example by the instructor the error stated => possible lossy conversion from
        // int to byte
        // so Java assumes without a specific cast the result of the operation will be an int
        // which is the default whole number data type, but it is being assigned to a byte
        // value so this is what an error is thrown
        // the statement myNewByteValue = (-128 / 2) works without casting because by using
        // literal values Java can calculate the result and see that it can fit into the Byte range
        // of values
        assertEquals(-64, myNewByteValue);


    }

    @Test
    void primitiveTypesChallengeTest() {
        byte myByteVariable = (byte) (40);
        short myShortVariable = (short) 400;
        int myIntVariable = 40_000;
        long myLongVariable =  (long) (50_000 + 10 * (myByteVariable + myShortVariable + myIntVariable));
        long expected = 454_400;

        assertEquals(expected, myLongVariable);

        // instructor solution
        myLongVariable = 50_000L + 10L * (myByteVariable + myShortVariable + myIntVariable);
        assertEquals(expected, myLongVariable);
    }

    // it is no longer necessary to run the same tests for the remaining whole number
    // data types as they will follow the pattern of the Byte and Integer behavior.
}
