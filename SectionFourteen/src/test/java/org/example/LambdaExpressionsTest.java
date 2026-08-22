package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaExpressionsTest {


    String extraToString(String string) {
        return string + "\n";
    }

    List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
    }

    @Test
    public void testFirstToStringMethods() {
        String expected = "alpha\nbravo\ncharlie\ndelta\n";

        String firstResult = "";
        for(String letter : list) {
            firstResult = firstResult.concat(extraToString(letter));
        }

        assertEquals(expected, firstResult);
    }

    @Test
    public void testSecondToStringMethods() {
        String expected = "alpha\nbravo\ncharlie\ndelta\n";

        StringBuilder secondResult = new StringBuilder();
        list.forEach((s) -> secondResult.append(extraToString(s)));

        assertEquals(expected, secondResult.toString());
    }

    @Test
    public void testSecondToStringMethodsWithCodeBlock() {
        String expected = "alpha means a\nbravo means b\ncharlie means c\ndelta means d\n";

        StringBuilder secondResult = new StringBuilder();
        list.forEach(myString -> {
            char first = myString.charAt(0);
            secondResult.append(myString).append(" means ").append(first).append("\n");
        });

        assertEquals(expected, secondResult.toString());
    }

    @Test
    public void testSecondToStringMethodsWithPrefix() {
        String expected = """
            Nato alpha means a
            Nato bravo means b
            Nato charlie means c
            Nato delta means d
            """;

        StringBuilder secondResult = new StringBuilder();
        String prefix = "Nato";
        list.forEach(myString -> {
            char first = myString.charAt(0);
            secondResult.append(prefix).append(" ").append(myString)
                .append(" means ").append(first).append("\n");
        });

        assertEquals(expected, secondResult.toString());
    }
}
