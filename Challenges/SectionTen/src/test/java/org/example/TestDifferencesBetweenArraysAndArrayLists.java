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
        public void testInstantiateEmptyArray() {
            String[] array = new String[10];

            assertEquals(10, array.length);
        }

        @Test
        public void testEmptyArraysHaveNullAsValuesForObjects() {
            String[] array = new String[10];

            for (String value : array) assertNull(value);
        }

        @Test
        public void testInstantiateEmptyArrayList() {
            ArrayList<String> list = new ArrayList<>();

            assertEquals(0, list.size());
        }

        @Test
        public void testInstantiateArrayWithData() {
            String[] array = {"zero", "one", "two", "three", "four"};

            assertEquals("zero", array[0]);
            assertEquals("one", array[1]);
            assertEquals("two", array[2]);
            assertEquals("three", array[3]);
            assertEquals("four", array[4]);
        }

        @Test
        public void testInstantiateArrayListWithData() {
            List<String> list = List.of("zero", "one", "two", "three", "four");

            assertEquals("zero", list.get(0));
            assertEquals("one", list.get(1));
            assertEquals("two", list.get(2));
            assertEquals("three", list.get(3));
            assertEquals("four", list.get(4));
        }
    }
}
