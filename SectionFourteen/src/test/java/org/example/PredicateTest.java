package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {

    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(
            List.of(
                "alpha", "bravo", "charlie", "delta",
                "echo", "foxtrot", "golf", "hotel",
                "bravo"
            )
        );
    }

    @Nested
    @DisplayName("test removal of items from list")
    class TestRemovalOfItemsFromList {

        @Test
        public void testRemovalOfItemsFromList() {
            List<String> removalList = new ArrayList<>(
                List.of("bravo", "delta", "foxtrot", "hotel")
            );

            for (String letter : removalList) {
                list.removeIf(s -> s.equalsIgnoreCase(letter));
            }

            // list.removeIf(...) removed both instances of bravo.  This
            // method removes all instances of the object in the list.
            List<String> resultantList = new ArrayList<>(
                List.of("alpha", "charlie", "echo", "golf")
            );

            assertEquals(resultantList, list);
        }

        @Test
        public void testRemovingAddedItemsToList() {
            list.addAll(List.of("easy", "earnest", "each"));
            List<String> modifiedList = new ArrayList<>(
                List.of(
                    "alpha", "bravo", "charlie", "delta",
                    "echo", "foxtrot", "golf", "hotel",
                    "bravo", "easy", "earnest", "each"
                )
            );
            assertEquals(modifiedList, list);
            list.removeIf(s -> s.startsWith("ea"));

            List<String> originalList = new ArrayList<>(
                List.of(
                    "alpha", "bravo", "charlie", "delta",
                    "echo", "foxtrot", "golf", "hotel",
                    "bravo"
                )
            );

            assertEquals(originalList, list);
        }
    }
}
