package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListAddAndRemoveElementsTest {

    LinkedList<String> firstPlacesToVisit;

    @BeforeEach
    public void setUp() {
        firstPlacesToVisit = new LinkedList<String>();
    }

    @Test
    public void testOtherWaysToDeclareLinkedLists() {
        String[] expected = {"LinkedList", "LinkedList"};
        LinkedList<String> firstList = new LinkedList<>();
        var secondList = new LinkedList<String>();
        String firstListClass = firstList.getClass().getSimpleName();
        String secondListClass = secondList.getClass().getSimpleName();
        String[] result = {firstListClass, secondListClass};
        assertArrayEquals(expected, result);
    }
}
