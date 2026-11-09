package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeepDiveIntoEqualsAndHashCode {

    private String aText, bText, cText, dText, eText;
    private List<String> hellos;
    private Set<String> mySet;

    @BeforeEach
    public void setUp() {
        aText = "Hello";
        bText = "Hello";
        cText = String.join("l", "He", "lo");
        dText = "He".concat("llo");
        eText = "hello";
        hellos = new ArrayList<>(
            List.of(aText, bText, cText, dText, eText)
        );
        mySet = new HashSet<>(hellos);
    }

    @Test
    public void testAllStringsHaveTheSameHashCodeExceptTheLastString() {
        int secondToLastIndex = 3;
        int lastIndex = 4;
        List<String> results = new ArrayList<>();
        for (String text : hellos) {
            results.add(String.valueOf(text.hashCode()));
        }
        for (int index = 0; index < results.size() + 1; index+=1) {
            if (index < 3) {
                String firstHashCode = results.get(index);
                String secondHashCode = results.get(index + 1);
                assertEquals(firstHashCode, secondHashCode);
            }
        }
        assertNotEquals(results.get(secondToLastIndex), results.get(lastIndex));
    }

    @Test
    public void testSetsOnlyRetainUniqueElements() {
        String expected = "[Hello, hello]";
        String results = mySet.toString();

        assertEquals(2, mySet.size());
        assertEquals(expected, results);
    }

    @Test
    public void testStringPool() {
        /*
            In Java String literals are interned, put in a special cache, if the string exists in the
            string pool, Java reuses that reference.  a == b checks the reference value, a.equals(b)
            checks the content.  When calling String.concat(), a new object is created in heap memory,
            which will not have the same address as the literal.  This is demonstrated in the test below.
        */
        assertTrue(aText.equals(bText));
        assertTrue(aText == bText);

        assertEquals(aText, cText); // Same content.
        assertNotSame(aText, cText); // Different objects

        assertTrue(aText == cText.intern());
        // intern() tells Java to look for the string in the string pool.
    }
}
