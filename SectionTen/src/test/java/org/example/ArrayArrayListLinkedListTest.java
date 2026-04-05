package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayArrayListLinkedListTest {
    int[] array;
    ArrayList<Integer> arrayList, secondArrayList, thirdArrayList;
    LinkedList<Integer> linkedList;

    // This file is a reference on how to initialize the collections I have learned so far.
    @BeforeEach
    public void setUp() {
        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        secondArrayList = new ArrayList<>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        thirdArrayList = new ArrayList<>(Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toList());
        linkedList = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testContainerSizes() {
        int[] expectedSizes = {10, 10, 10, 10, 10};
        int[] resultantSizes = {
                array.length,
                arrayList.size(),
                secondArrayList.size(),
                thirdArrayList.size(),
                linkedList.size()
        };
        assertArrayEquals(expectedSizes, resultantSizes);
    }
}
