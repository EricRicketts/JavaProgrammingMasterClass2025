package org.example.SectionFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModifyHelloWorld {

    private String myString;

    @Test
    public void testModifyHelloWorld() {
        myString = "Eric Ricketts";
        Assertions.assertEquals("Eric Ricketts", myString);
    }
}
