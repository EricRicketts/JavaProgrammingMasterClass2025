package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InstantiatingArraysTest {

    String[] array;

    @Test
    public void testInstantiateArrayWithoutValues() {
        array = new String[10];
        assertEquals(10, array.length);
        assertNull(array[0]);
    }

    @Test
    public void testInstantiateArrayWithInitializer() {
        array = new String[]{"first", "second", "third"};
        assertEquals(3, array.length);
        assertEquals("first", array[0]);
        assertEquals("second", array[1]);
        assertEquals("third", array[2]);
    }

    @Test
    public void testInstantiateArrayWithAnonymousInitializer() {
        // Anonymous declaration needs the type even if the variable has been
        // previously declared.
        String[] array = {"first", "second", "third"};

        assertEquals(3, array.length);
        assertEquals("first", array[0]);
        assertEquals("second", array[1]);
        assertEquals("third", array[2]);
    }

    @Test
    public void testInstantiateMultiDimensionalArray() {
        String[][] array2d = {
            {"first", "second", "third"},
            {"fourth", "fifth"}
        };

        assertEquals(2, array2d.length);
        assertEquals(3, array2d[0].length);
        assertEquals(2, array2d[1].length);

        assertEquals("first", array2d[0][0]);
        assertEquals("second", array2d[0][1]);
        assertEquals("third", array2d[0][2]);

        assertEquals("fourth", array2d[1][0]);
        assertEquals("fifth", array2d[1][1]);
    }
}
