package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class UnaryOperatorTest {

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
    private List<String> list;
    private String[] emptyStrings;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(
            List.of(
                "alpha", "bravo", "charlie", "delta",
                "echo", "foxtrot", "golf", "hotel"
            )
        );

        emptyStrings = new String[10];
    }

    @Nested
    @DisplayName("Test Unary Operations")
    class TestUnaryOperations {

        @Test
        public void testReplaceAll() {
            List<String> expected = new ArrayList<>(
                List.of(
                "a - ALPHA", "b - BRAVO", "c - CHARLIE", "d - DELTA",
                "e - ECHO", "f - FOXTROT", "g - GOLF", "h - HOTEL"
                )
            );
            list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());

            assertEquals(expected, list);
        }
        /*
            For the two tests below, an array type String is provided as the argument to the
            fill or setAll methods; the return type is also an array type String.
         */
        @Test
        public void testArraysFill() {
            Arrays.fill(emptyStrings, "foo");
            String[] expected =
                {"foo", "foo", "foo", "foo", "foo", "foo", "foo", "foo", "foo", "foo"};
            assertArrayEquals(expected, emptyStrings);
        }

        @Test
        public void testArraysSetAll() {
            Arrays.setAll(emptyStrings, (i) -> (i + 1) + ". " +
                switch(i) {
                    case(0) -> "one";
                    case(1) -> "two";
                    case(2) -> "three";
                    default -> "";
                });
            String[] expected =
                {"1. one", "2. two", "3. three", "4. ", "5. ", "6. ", "7. ", "8. ", "9. ", "10. "};

            assertArrayEquals(expected, emptyStrings);
        }

        @Test
        public void testArraysSetWithRandomlySelectedValuesMethod() {
            String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
            String[] randomList = randomlySelectedValues(
                15,
                names,
                () -> new Random().nextInt(0, names.length));
            assertEquals(15, randomList.length);
            for (int i = 0; i < randomList.length; i++) {
                String name = randomList[i];
                assertTrue(Arrays.asList(randomList).contains(name));
            }
        }


    }
}
