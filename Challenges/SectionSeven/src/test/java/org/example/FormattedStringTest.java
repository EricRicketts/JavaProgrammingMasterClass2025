package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormattedStringTest {

    @Test
    public void testFormattedStrings() {
        String firstFormatted = String.format("The number in question is %.2f.", 34.567);
        String secondFormatted = "The number in question is %.2f.".formatted(34.567);
        assertEquals(firstFormatted, secondFormatted);
    }
}
