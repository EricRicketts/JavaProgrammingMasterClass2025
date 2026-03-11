package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForLoopRecapWhleAndDoWhileExampleTest {

    int expectedSum = 9;

    @Test
    public void testForLoop() {
        Integer result = ForLoopRecapAndWhileAndDoWhileLoops.forLoopExample();
        assertEquals(expectedSum, result);
    }

    @Test
    public void testWhileLoop() {
        Integer result = ForLoopRecapAndWhileAndDoWhileLoops.whileLoopExample();
        assertEquals(expectedSum, result);
    }

    @Test
    public void testDoWhileLoop() {
        Integer result = ForLoopRecapAndWhileAndDoWhileLoops.doWhileLoopExample();
        assertEquals(expectedSum, result);
    }
}
