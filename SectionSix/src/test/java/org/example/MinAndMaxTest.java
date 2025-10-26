package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinAndMaxTest {
    MinAndMax minAndMax;

    @BeforeEach
    public void setUp() {
        minAndMax = new MinAndMax();
    }

    @Test
    public void testSetMinAndMaxWithIntegerZero() {
        minAndMax.setMinAndMax(0);
        Assertions.assertEquals(0, minAndMax.getMin());
        Assertions.assertEquals(0, minAndMax.getMax());
    }

    @Test
    public void testSetMinAfterOneIteration() {
        minAndMax.setMinAndMax(0);
        minAndMax.setMinAndMax(-1);
        Assertions.assertEquals(-1, minAndMax.getMin());
        Assertions.assertEquals(0, minAndMax.getMax());
    }

    @Test
    public void testSetMaxAfterOneIteration() {
        minAndMax.setMinAndMax(0);
        minAndMax.setMinAndMax(1);
        Assertions.assertEquals(0, minAndMax.getMin());
        Assertions.assertEquals(1, minAndMax.getMax());
    }

    @Test
    public void testSetMinAndMax() {
        minAndMax.setMinAndMax(2);
        minAndMax.setMinAndMax(1);
        minAndMax.setMinAndMax(3);
        Assertions.assertEquals(1, minAndMax.getMin());
        Assertions.assertEquals(3, minAndMax.getMax());
    }
}
