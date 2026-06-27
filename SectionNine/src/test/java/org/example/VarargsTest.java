package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VarargsTest {
    String firstString, expected, result;
    String[] stringArray;

    @BeforeEach
    public void setUp() {
        expected = "Hello".concat("\n").concat("World").concat("\n").concat("Again");
        firstString = "Hello World Again";
        stringArray = "Hello World Again".split(" ");
    }

    @Nested
    @DisplayName("test varargs options")
    class TestVarArgsOptions {

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
}
