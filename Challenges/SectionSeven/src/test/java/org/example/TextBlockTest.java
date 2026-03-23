package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        formattedString =
                formattedString.replaceAll("\t", "    ").replace(" ", "·");
        textBlock =
                textBlock.replaceAll("\t", "    ").replace(" ", "·");
        int max = Math.max(formattedString.length(), textBlock.length());
        for (int i = 0; i < max; i++) {
            char ca = (i < formattedString.length()) ? formattedString.charAt(i) : '\0';
            char cb = (i < textBlock.length()) ? textBlock.charAt(i) : '\0';
            String mismatchMessage =
                    "Mismatch at index " + i + " a = [" + (int) ca + "], " +
                            "b = [" + (int) cb + "]";
            Assertions.assertEquals(ca, cb, mismatchMessage);
        }
    }
}
