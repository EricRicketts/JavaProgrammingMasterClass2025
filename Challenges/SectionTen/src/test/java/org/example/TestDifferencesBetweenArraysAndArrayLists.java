package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDifferencesBetweenArraysAndArrayLists {

    private String[] array;
    private List<String> list;

    @BeforeEach
    public void setUp() {
        array = new String[]{"zero", "one", "two", "three", "four"};
        list = Arrays.asList(array);
    }

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

    @Nested
    @DisplayName("test arrays and certain array lists are immutable")
    class TestArrayFixedSizeCertainArrayListsFixedSize {

        @Test
        public void testArraysCanModifyIndividualElements() {
            assertEquals("zero", array[0]);

            array[0] = "infinity";
            assertEquals("infinity", array[0]);
        }

        @Test
        public void testCannotAddToAListBackedByAnArray() {
            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                    UnsupportedOperationException.class,
                    () -> list.add("five")
                );

            assertNull(unsupportedOperationException.getMessage());
        }

        @Test
        public void testCannotRemoveFromAListBackedByAnArray() {
            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                    UnsupportedOperationException.class,
                    () -> list.remove(4)
                );

            assertNull(unsupportedOperationException.getMessage());
        }

        @Test
        public void testAnotherWayToCreateAnImmutableListWhichCannotBeAddedTo() {
            List<String> newList = List.of("ten", "nine", "eight");

            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                    UnsupportedOperationException.class,
                    () -> list.add("seven")
               );

            assertNull(unsupportedOperationException.getMessage());
        }

        @Test
        public void testAnotherWayToCreateAnImmutableListWhichCannotBeRemovedFrom() {
            List<String> newList = List.of("ten", "nine", "eight");

            UnsupportedOperationException unsupportedOperationException =
                assertThrows(
                    UnsupportedOperationException.class,
                    () -> list.remove(2)
                );

            assertNull(unsupportedOperationException.getMessage());
        }

        @Test
        public void testChangesToArrayBakingTheListAreMadeToTheList() {
            assertEquals("four", array[4]);
            assertEquals("four", list.get(4));

            array[4] = "infinity";

            assertEquals("infinity", array[4]);
            assertEquals("infinity", list.get(4));
        }

        @Test
        public void testChangesToTheListAreMadeToTheArrayBackingTheList() {
            assertEquals("four", array[4]);
            assertEquals("four", list.get(4));

            list.set(4, "infinity");

            assertEquals("infinity", array[4]);
            assertEquals("infinity", list.get(4));
        }

        @Test
        public void testArrayListNotBackByAnArrayCanGrowInSize() {
            ArrayList<String> list = new ArrayList<>(List.of(array));

            assertEquals(5, list.size());

            list.add("five");

            assertEquals(6, list.size());
            assertEquals("five", list.get(5));
            assertEquals(5, array.length);
        }

        @Test
        public void testArrayListNotBackByAnArrayCanShrinkInSize() {
            ArrayList<String> list = new ArrayList<>(List.of(array));

            assertEquals(5, list.size());

            String removedItem = list.remove(4);

            assertEquals(4, list.size());
            assertEquals("four", removedItem);
            assertEquals(5, array.length);
        }

        @Test
        public void testChangesToListNoBackedByArrayDoesNotAffectArray() {
            ArrayList<String> list = new ArrayList<>(List.of(array));

            assertEquals("one", list.get(1));
            list.set(1, "another one");

            assertEquals("another one", list.get(1));
            assertEquals("one", array[1]);
        }
    }
}
