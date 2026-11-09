package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeepDiveIntoEqualsAndHashCode {

    private String aText, bText, cText, dText, eText;
    private List<String> hellos;

    @BeforeEach
    public void setUp() {
        aText = "Hello";
        bText = "Hello";
        cText = String.join("l", "He", "lo");
        dText = "He".concat("llo");
        eText = "hello";
        hellos = new ArrayList<>(
            List.of(aText, bText, cText, dText, eText)
        );
    }

    @Test
    public void testAllStringsHaveTheSameHashCodeExceptTheLastString() {
        int secondToLastIndex = 3;
        int lastIndex = 4;
        List<String> results = new ArrayList<>();
        for (String text : hellos) {
            results.add(String.valueOf(text.hashCode()));
        }
        for (int index = 0; index < results.size() + 1; index+=1) {
            if (index < 3) {
                String firstHashCode = results.get(index);
                String secondHashCode = results.get(index + 1);
                assertEquals(firstHashCode, secondHashCode);
            }
        }
        assertNotEquals(results.get(secondToLastIndex), results.get(lastIndex));
    }
}
