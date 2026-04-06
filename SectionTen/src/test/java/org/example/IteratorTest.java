package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorTest {

    LinkedList<String> list;
    String expected, result;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>(Arrays.asList(
                "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka")
        );
    }

    @Test
    public void testInitializedList() {
        expected =  "[Honolulu, Boise, Springfield, Indianapolis, Des Moines, Topeka]";
        result = list.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveItemFromIterator() {
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("Springfield")) iterator.remove();
        }
        expected = "[Honolulu, Boise, Indianapolis, Des Moines, Topeka]";
        result = list.toString();
        assertEquals(expected, result);
    }
}
