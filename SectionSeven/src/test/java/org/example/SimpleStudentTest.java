package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleStudentTest {

    @Test
    public void testSimpleStudent() {
        /*
            There is no toString() method defined in the SimpleStudent class.
            Every class in Java inherits from the Object class, which is at
            the top of the class hierarchy, and the toString() method is defined
            in the Object class.  The default return from toString is
            "org.example.ClassName@HashCode".  I use the split operation, splitting
            on the "@" character to get the class name and then the hash code.  Since
            the hash code is not a constant, regular expressions were used to match
            the hash code format, which is an 8-character combination of letters and
            numbers.
            One other item to remember is that when passing an object to the print or
            println methods, the toString() method defined in the class is called.  So
            System.out.print(max) or System.out.println(max) would both print
            "org.example.SimpleStudent@hashcode".
        */
        String regex = "^[a-zA-Z0-9]{8}$";
        SimpleStudent max = new SimpleStudent("max", 21);
        String expected = "org.example.SimpleStudent";
        String[] result = max.toString().split("@");
        String beforeHashCode = result[0];
        String afterHashCode = result[1];
        assertEquals(expected, beforeHashCode);
        assertTrue(afterHashCode.matches(regex));
    }
}
