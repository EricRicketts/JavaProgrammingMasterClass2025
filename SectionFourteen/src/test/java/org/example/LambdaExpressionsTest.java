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
}
