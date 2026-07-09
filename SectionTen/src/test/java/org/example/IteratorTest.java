package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    public void testIteratorOnlyAllowsForwardMovement() {
        assertEquals(6, list.size());
        list.add(2, "Springfield");
        list.add(6, "Springfield");
        assertEquals(8, list.size());

        list.removeIf(s -> s.equals("Springfield"));
        assertEquals(5, list.size());

        expected = "[Honolulu, Boise, Indianapolis, Des Moines, Topeka]";
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

    @Test
    public void testListIteratorAdd() {
        String output = "";
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals("Springfield")) listIterator.add("Boston");
        }
        expected = "[Honolulu, Boise, Springfield, Boston, Indianapolis, Des Moines, Topeka]";
        result = list.toString();
        assertEquals(expected, result);
        // Now, traverse in the reverse.
        while (listIterator.hasPrevious()) {
            output = output.concat(listIterator.previous()) + ", ";
        }
        expected = "Topeka, Des Moines, Indianapolis, Boston, Springfield, Boise, Honolulu";
        output = output.replaceAll(", $", "");
        assertEquals(expected, output);
    }

    @Test
    public void testListIteratorMoveForwardThroughList() {
        /*
        while(listIterator.hasNext()) {
            if (listIterator.next().equals("Springfield")) {
                listIterator.add("Raleigh");
            } else if (listIterator.next().equals("Des Moines")) {
                listIterator.add("Front Royal");
            }
        }

        Inside one loop iteration, you may call `listIterator.next()` **twice**:
        1. Once in the `if`
        2. Again in the `else if`

        That advances the iterator two positions during a single loop pass.
            Eventually, the `while (listIterator.hasNext())` check succeeds because
            there is one item left, but then the first `next()` consumes
            that last item. If the `if` condition is false, the `else if`
            calls `next()` again, and there is no next element left, causing the `
        NoSuchElementException`.

        ## Long-term fix
        Call `next()` **once per loop iteration**, store the value in a variable,
        and then compare that variable.
         */
        expected = "[Honolulu, Boise, Springfield, Raleigh, " +
            "Indianapolis, Des Moines, Front Royal, Topeka]";
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String city = listIterator.next();

            if (city.equals("Springfield")) {
                listIterator.add("Raleigh");
            } else if (city.equals("Des Moines")) {
                listIterator.add("Front Royal");
            }
        }
        result = list.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testListIteratorMoveBackwardThroughList() {
        String city = "";
        expected = "[Honolulu, Boise, Springfield, Raleigh, " +
            "Indianapolis, Des Moines, Front Royal, Topeka]";
        var listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            city = listIterator.next();

            if (city.equals("Springfield")) {
                listIterator.add("Raleigh");
            } else if (city.equals("Des Moines")) {
                listIterator.add("Front Royal");
            }
        }
        result = list.toString();
        assertEquals(expected, result);

        while (listIterator.hasPrevious()) {
            city = listIterator.previous();

            if (city.equals("Front Royal")) {
                listIterator.remove();
            } else if (city.equals("Raleigh")) {
                listIterator.remove();
            }
        }

        expected = "[Honolulu, Boise, Springfield, " +
            "Indianapolis, Des Moines, Topeka]";
        result = list.toString();

        assertEquals(expected, result);
    }
}
