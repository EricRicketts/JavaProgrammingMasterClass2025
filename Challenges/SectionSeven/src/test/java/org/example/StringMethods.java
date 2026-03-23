package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringMethods {

    String sampleString, emptyString = "", blankString;
    StringBuilder sb;

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

    @Test
    public void testStringManipulationMethods() {
        // I find the index of the first index of 'e' then the substring method will
        // Get the substring starting at 'e' and working to the end of the text.
        // All of these String methods return a new String because Strings are immutable.
        String birthDay = "11/20/1960";
        sampleString = "This is sample text.";
        int startingIndex = sampleString.indexOf('e');
        assertEquals("e text.", sampleString.substring(startingIndex));
        int endingIndex = sampleString.lastIndexOf('x');
        // When you bracket a substring search the ending index is not inclusive.
        assertEquals("e te", sampleString.substring(startingIndex, endingIndex));
        assertEquals("11/20/1960", String.join("/", "11", "20", "1960" ));
        assertEquals("This is a concatenated String.",
                "This is a ".concat("concatenated String."));
        assertEquals("11-20-1960", "11/20/1960".replace('/', '-'));
        assertEquals("12/20/1960", "11/20/1960".replaceFirst("11", "12"));
        assertEquals("11/20000/1960000", "11/20/1960".replaceAll("0", "0000"));
        assertEquals("  abc", "abc".indent(2).stripTrailing());
    }

    @Test
    public void testStringMethodsCreateANewString() {
        sampleString = "A new String.";
        String newString = sampleString.concat("  Another string.");
        assertEquals("A new String.  Another string.", newString);
        assertEquals("A new String.", sampleString);
    }

    @Test
    public void testStringBuilderModifiesCurrentStringBuilder() {
        sb = new StringBuilder("A new String.");
        assertEquals("A new String.", sb.toString());
        sb.append("  Another string.");
        assertEquals("A new String.  Another string.", sb.toString());
    }

    @Test
    public void testStringBuilderDefaultCapacity() {
        // StringBuilder is the number of characters to start with before requesting new memory.
        int[] expectedCapacities = new int[]{16, 32};
        int[] capacities = new int[]{
                new StringBuilder().capacity(), new StringBuilder(32).capacity()
        };
        assertArrayEquals(expectedCapacities, capacities);
    }

    @Test
    public void testDeleteAndInsertIntoAStringBuilderObject() {
        /*
            The deleteCharAt deletes the char at the exact index given.  The insert method
            inserts the string before the given offset.  When we delete a character, the size
            of the StringBuilder object drops by 1, so the deleted index advances more space
            towards the end of the string.  The insert operation starts one character before
            the offset.
        */
        sb = new StringBuilder("A new String.  Another String.");
        sb.deleteCharAt(6).insert(6, "s")
                .deleteCharAt(23).insert(23, "s");
        assertEquals("A new string.  Another string.", sb.toString());
    }

    @Test
    public void testStringBuilderReplaceMethod() {
        // As with the insert method, the ending index is not included in the replacement,
        // the last character inserted ends at index 15, not index 16.
        sb = new StringBuilder("A new and bigger string.");
        sb.replace(10, 16, "smaller");
        assertEquals("A new and smaller string.", sb.toString());
    }
}
