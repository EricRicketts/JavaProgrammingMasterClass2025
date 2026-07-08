package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestDifferencesBetweenArraysAndArrayLists {

    @Nested
    @DisplayName("test instantiate arrays and array lists")
    class TestInstantiateArraysAndArrayLists {

        @Test
        public void testInstantiateEmptyArraysAndArrayLists() {
            String[] array = new String[10];
            ArrayList<String> list = new ArrayList<>();

            assertEquals(10, array.length);
            assertNull(array[4]); // All objects initialized to null in an empty array.
            assertEquals(0, list.size());
        }

        @Test
        public void testInstantiateArrayAndArrayListsWithData() {
            String[] array = {"zero", "one", "two", "three", "four"};
            ArrayList<String> list = new ArrayList<>(List.of(array));

            assertEquals(5, array.length);
            assertEquals("two", array[2]);
            assertEquals(5, list.size());
            assertEquals("two", list.get(2));
        }
    }
}
