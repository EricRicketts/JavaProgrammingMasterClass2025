package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LambdaExpressionChallengeTest {

    private String[] names = {"Bob", "George", "William", "Eric", "Anna", "Racecar", "Deified"};
    private String[] expected;
    private List<String> listOfNames;

    @BeforeEach
    public void setUp() {
        listOfNames = new ArrayList<>(List.of(names));
    }

    @Test
    public void testTransformNamesToAllUpperCase() {
        Arrays.setAll(names, i -> names[i].toUpperCase());

        expected = new String[]{"BOB", "GEORGE", "WILLIAM", "ERIC", "ANNA", "RACECAR", "DEIFIED"};

        assertArrayEquals(expected, names);
    }
}