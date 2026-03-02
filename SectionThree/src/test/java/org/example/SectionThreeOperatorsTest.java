package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionThreeOperatorsTest {
    @Test
    public void compoundAssignmentTest() {
        int result = 10;
        int secondResult = 10;
        result += 5;
        secondResult -= 5;
        Assertions.assertEquals(15, result);
        Assertions.assertEquals(5, secondResult);
    }

    @Test
    public void postIncrementOperatorTest() {
        int result = 10;
        result++;
        Assertions.assertEquals(11, result);
    }

    @Test
    public void postDecrementOperatorTest() {
        int result = 10;
        result--;
        Assertions.assertEquals(9, result);
    }

    @Test
    public void compoundAssignmentQuirkTest() {
        int result = 10;
        result -= 5.5;
        // result = result - 5.5, an implicit cast occurs to guard against errors but
        // unexpected results may occur it is really => result = (data type of result) (result - 5.5)
        // since the cast is an int then (result - 5.5) = 4.5 which is truncated to 4
        Assertions.assertEquals(4, result);
    }

    @Test
    public void postMultiplicativeCompoundOperatorTest() {
        int result = 10;
        result *= 2;
        Assertions.assertEquals(20, result);
    }

    @Test
    public void postDivideCompoundOperatorTest() {
        int result = 10;
        result /= 2;
        Assertions.assertEquals(5, result);
    }

    @Test
    public void modulusOperatorTest() {
        Assertions.assertEquals(2, 5 % 3);
    }
}
