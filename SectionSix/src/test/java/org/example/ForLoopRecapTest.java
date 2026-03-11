package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForLoopRecapTest {

    @Test
    public void testForLoopRecap() {
        Integer result = ForLoopRecap.forLoopExample();
        assertEquals(9, result);
    }
}
