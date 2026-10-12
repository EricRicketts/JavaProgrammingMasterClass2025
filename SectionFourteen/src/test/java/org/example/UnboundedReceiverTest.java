package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnboundedReceiverTest {

    private int integerResult;

    @Test
    public void testCalculatorWithStandardLambdaExpression() {
         integerResult = Calculator.calculator((s1, s2) -> s1 + s2, 5, 10);

        assertEquals(15, integerResult);
    }

    @Test
    public void testCalculatorWithMethodReference() {
        integerResult = Calculator.calculator(Integer::sum, 5, 10);
        
        assertEquals(15, integerResult);
    }
}
