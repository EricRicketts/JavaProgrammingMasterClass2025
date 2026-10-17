package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntroductionToCollectionsTest {

    List<String> listOfNames = new ArrayList<>();
    List<String> expected = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        listOfNames.addAll(Arrays.asList(names));
        expected.addAll(Arrays.asList(names));
    }

    @Nested
    @DisplayName("test add elements to a list")
    class TestAddElementsToAList {

        @Test
        public void testAddASingleElementToAList() {
            assertEquals(5, listOfNames.size());
            assertEquals(expected, listOfNames);
            listOfNames.add("Fred");

            assertEquals(6, listOfNames.size());
            assertEquals("Fred", listOfNames.getLast());
        }

        @Test
        public void testAddMultipleElementsToAList() {
            assertEquals(5, listOfNames.size());
            listOfNames.addAll(Arrays.asList("George", "Gary", "Grace"));

            assertEquals(8, listOfNames.size());
            expected.clear();
            expected.addAll(Arrays.asList("George", "Gary", "Grace"));

            List<String> subList = listOfNames.subList(5, listOfNames.size());
            assertEquals(expected, subList);
        }

        @Test
        public void testAddAListToAList() {
            List<String> otherNames = new ArrayList<>(List.of("George", "Gary", "Grace"));
            assertEquals(5, listOfNames.size());

            listOfNames.addAll(otherNames);
            assertEquals(8, listOfNames.size());
            assertEquals(otherNames, listOfNames.subList(5, listOfNames.size()));
        }
    }

    @Nested
    @DisplayName("test does a list contain an element")
    class TestListContainsElement {

        @Test
        public void testListContainsSingleElement() {
            assertTrue(listOfNames.contains("Carol"));
        }
    }
}
