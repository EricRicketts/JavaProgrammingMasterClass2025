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
        assertEquals(19, sampleString.indexOf('r'));
        assertEquals(65, sampleString.lastIndexOf('p'));
        // below we find the second 'p' position starting from index 19
        assertEquals(24, sampleString.indexOf('p', 19));
        // starts and index 56 and then works backwards to find the first occurrence of the letter.
        assertEquals(39, sampleString.lastIndexOf('n', 56));
        assertEquals(46, sampleString.lastIndexOf('i', 56));
        assertTrue(emptyString.isEmpty());
        assertTrue(blankString.isBlank());
    }

    @Test
    public void testStringComparisonMethods() {
        sampleString = "This IS a sample Text.";
        assertEquals("this is a sample text.", sampleString.toLowerCase());
        assertTrue("This IS a sample Text.".equals(sampleString));
        assertTrue(sampleString.startsWith("Thi"));
        assertTrue(sampleString.endsWith("xt."));
        assertTrue(sampleString.contains("a s"));
    }
}
