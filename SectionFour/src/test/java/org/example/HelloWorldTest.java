package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HelloWorldTest {
    String myString;

    @Test
    public void testHelloWorld() {
        myString = "Hello World";
        Assertions.assertEquals("Hello World", myString);
    }

    @Test
    public void testModifyHelloWorld() {
       myString = "Eric Ricketts";
       Assertions.assertEquals("Eric Ricketts", myString);
    }
}
