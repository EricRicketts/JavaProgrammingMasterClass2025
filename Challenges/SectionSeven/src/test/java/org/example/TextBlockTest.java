package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBlockTest {

    String formattedString, textBlock;

    @BeforeEach
    public void setUp() {
        formattedString = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        textBlock = """
                    Print a Bulleted List:
                        \u2022 First Point
                            \u2022 Sub Point""";
    }

    @Test
    public void testFormattedStringAndTextBlockAreEqual() {
        assertEquals(formattedString, textBlock);
    }
}
