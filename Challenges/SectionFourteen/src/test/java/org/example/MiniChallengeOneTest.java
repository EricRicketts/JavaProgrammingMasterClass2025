package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MiniChallengeOneTest {

    private List<String> listOfParts;
    private String whole;
    private String[] expected;

    @BeforeEach
    public void setUp() {
        listOfParts = new ArrayList<>();
        whole = "Abel Baker Charlie Dog Echo Foxtrot";
        expected = new String[]{"Abel", "Baker", "Charlie", "Dog", "Echo", "Foxtrot"};
    }

    @Test
    public void testSeparateOutPartsFromWhole() {
        Consumer<String> splitAndCapture = s -> {
            String[] parts = s.split("\\s+");
            for (String part : parts) {
                listOfParts.add(part);
            }
        };
        splitAndCapture.accept(whole);

        assertArrayEquals(expected, listOfParts.toArray());
    }
}
