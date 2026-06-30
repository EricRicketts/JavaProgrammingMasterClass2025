package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InstantiatingArrayListsTest {

    ArrayList<String> arrayList;

    @Test
    public void testInstantiateArrayListWithoutValues() {
        arrayList = new ArrayList<>();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testInstantiateArrayListWithValues() {
        // To instantiate an array list with values you must use List.of or
        // something else one cannot use raw parameters like the following:
        // arrayList = new ArrayList<>("first", "second", "third")
        arrayList = new ArrayList<>(List.of("first", "second", "third"));
        assertEquals(3, arrayList.size());
        assertEquals("first", arrayList.getFirst());
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.getLast());
    }

    @Test
    public void testInstantiateArrayListWithArraysAsList() {
        arrayList = new ArrayList<>(Arrays.asList("first", "second", "third"));
        assertEquals(3, arrayList.size());
        assertEquals("first", arrayList.getFirst());
        assertEquals("second", arrayList.get(1));
        assertEquals("third", arrayList.getLast());
    }

    @Test
    public void testInstantiateArrayListWithImmutableResults() {
        List<String> list = List.of("first", "second", "third");
        assertEquals(3, list.size());
        assertEquals("first", list.getFirst());
        assertEquals("second", list.get(1));
        assertEquals("third", list.getLast());

        UnsupportedOperationException unsupportedOperationException =
            assertThrows(
                UnsupportedOperationException.class,
                () -> list.add("fourth")
            );
        assertNull(unsupportedOperationException.getMessage());
    }

    @Test
    public void testCreateAnArrayListFromAnArray() {
        String[] originalArray = new String[]{"first", "second", "third"};
        var originalList = Arrays.asList(originalArray);
        assertEquals(3, originalList.size());
        assertEquals("first", originalList.getFirst());
        assertEquals("second", originalList.get(1));
        assertEquals("third", originalList.getLast());

        // List is "backed by" an array.
        assertEquals(3, originalArray.length);
        assertEquals("first", originalArray[0]);
        assertEquals("second", originalArray[1]);
        assertEquals("third", originalArray[2]);

        // List backed by an array is immutable.
        UnsupportedOperationException unsupportedOperationException =
            assertThrows(
                UnsupportedOperationException.class,
                () -> originalList.add("fourth")
            );
        assertNull(unsupportedOperationException.getMessage());
    }

    @Test
    public void testInstantiateMultiDimensionalArrayList() {
        ArrayList<ArrayList<String>> multiDList = new ArrayList<>();

        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();

        a1.add("first");
        a1.add("second");
        a1.add("third");

        a2.add("fourth");
        a2.add("fifth");

        multiDList.add(a1);
        multiDList.add(a2);

        assertEquals(2, multiDList.size());
        assertEquals(3, multiDList.getFirst().size());
        assertEquals(2, multiDList.getLast().size());

        assertEquals("first", multiDList.getFirst().getFirst());
        assertEquals("second", multiDList.getFirst().get(1));
        assertEquals("third", multiDList.getFirst().getLast());

        assertEquals("fourth", multiDList.getLast().getFirst());
        assertEquals("fifth", multiDList.getLast().getLast());
    }
}
