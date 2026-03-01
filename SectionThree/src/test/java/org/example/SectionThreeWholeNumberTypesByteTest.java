package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeWholeNumberTypesByteTest {

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

    byte minValueByte = Byte.MIN_VALUE;
    byte maxValueByte = Byte.MAX_VALUE;
    String minValueByteString = Byte.toString(minValueByte);
    String maxValueByteString = Byte.toString(maxValueByte);
    String expectedByteMinValue = "-128";
    String expectedByteMaxValue = "127";

    @Test
    void byteValueRangeTest() {
        assertEquals(expectedByteMinValue, minValueByteString);
        assertEquals(expectedByteMaxValue, maxValueByteString);
    }

    @Test
    void byteOverflowTest() {
        byte overFlowByteMinValue = (byte) (Byte.MIN_VALUE - 1); // wraps to 127
        byte overFlowByteMaxValue = (byte) (Byte.MAX_VALUE + 1); // wraps to -128

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
        // int to byte, so Java assumes without a specific cast the result of the operation will be an int


        // "int" is the default whole number data type however, it is being assigned to a byte
        // value this is what an error is thrown
        // The statement myNewByteValue = (-128 / 2) works without casting because by using
        // literal values Java can calculate the result and see that it can fit into the Byte range
        assertEquals(-64, myNewByteValue);
    }
}
