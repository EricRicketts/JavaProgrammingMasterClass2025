package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DescendTest {

    Descend descend;
    int[] numbers, sort, sorted;

    @BeforeEach
    public void setUp() {
        numbers = new int[]{50, 25, 80, 5, 15, 65, 42};
        sorted = new int[]{80, 65, 50, 42, 25, 15, 5};
    }

    @Test
    public void testSorting() {
        sort = Descend.sort(numbers);
        assertArrayEquals(sorted, sort);
    }
}
