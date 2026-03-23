package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringMethods {

    String sampleString, emptyString = "", blankString;

    @BeforeEach
    public void setUp() {
        sampleString = "This is a sample string practicing coding 23 times a day will help @#% you!!";
        blankString = "   ";
    }

    @Test
    public void testStringInspectionMethods() {
        // Counting characters in a String begins at index 0.  For lastIndexOf the string length is 76
        // so the last index is 75, so one must start counting backwards from 75.
        assertEquals(76, sampleString.length());
        assertEquals( 'd', sampleString.charAt(37));
        assertEquals(19, sampleString.indexOf("r"));
        assertEquals(65, sampleString.lastIndexOf("p"));
        assertTrue(emptyString.isEmpty());
        assertTrue(blankString.isBlank());
    }
}
