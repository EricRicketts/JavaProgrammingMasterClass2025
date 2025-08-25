package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionThreeFloatAndDoubleNumbersTest {

    @Test
    void testFloatVariable() {
        // had to declare Float because default decimal format is Double
        Float expected = 5.25F;
        float  myFloatVariable = 5.25F;
        assertEquals(expected, myFloatVariable);
    }

    @Test
    void testDoubleVariable() {
        // since Double is default for decimal numbers no need to use "d" or "D" suffix
        Double expected = 5.25D;
        double  myDoubleVariable = 5.25D;
        assertEquals(expected, myDoubleVariable);
    }
}
