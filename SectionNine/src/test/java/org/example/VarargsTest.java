package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VarargsTest {
    String firstString, varargs, expected, result;
    String[] stringArray;

    @BeforeEach
    public void setUp() {
        expected = "Hello".concat("\n").concat("World").concat("\n").concat("Again");
        firstString = "Hello World Again";
        stringArray = "Hello World Again".split(" ");
    }

    @Test
    public void testVarargsWithString() {
        expected = "Hello World Again";
        result = Varargs.printText(firstString);
        assertEquals(expected, result);
    }

    @Test
    public void testVarargsWithStringArray() {
        result = Varargs.printText(stringArray);
        assertEquals(expected, result);
    }

    @Test
    public void testVarargsWithOneString() {
        expected = "Hello";
        result = Varargs.printText("Hello");
        assertEquals(expected, result);
    }

    @Test
    public void testVarargsWithAListOfStrings() {
        result = Varargs.printText("Hello", "World", "Again");
        assertEquals(expected, result);
    }
}
