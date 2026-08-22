package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalInterfaceTest {

    public static <T> T calculator(Operation<T> function, T value1, T value2) {

        StringBuilder sb = new StringBuilder();
        T result = function.operate(value1, value2);
        sb = sb.append("Result of Operation").append("result").append("\n");
        return result;
    }

    @Nested
    @DisplayName("Test functional interface")
    class TestFunctionalInterface {

        @Test
        public void testCalculator() {
            // The warning below is the IDE suggesting to use a method reference.
            // Note the pink icons next to the left of the lambda expressions, hovering
            // over them the pop-up says, "Overrides method in Operation".  Clicking the icon
            // takes one to the Operation Interface.
            int firstResult = calculator((a, b) -> a + b,  5, 2);
            int secondResult = calculator(Integer::sum, 5, 2);

            assertEquals(7, firstResult);
            assertEquals(firstResult, secondResult);
        }

        @Test
        public void testCalculatorWithExplicitTypeAndVar() {
            int firstResult = calculator((Integer a, Integer b) -> a + b, 5, 2);
            int secondResult = calculator((var a, var b) -> a + b, 5, 2);

            assertEquals(7, firstResult);
            assertEquals(7, secondResult);
        }

        @Test
        public void testCalculatorWithBigDecimal() {
            BigDecimal result = calculator(
                (a, b) -> a.divide(b, RoundingMode.HALF_UP),
                new BigDecimal("10.00"), new BigDecimal("2.50"));

            assertEquals(new BigDecimal("4.00"), result);
        }

        @Test
        public void testCalculatorWithStrings() {
            String result = calculator(
                (a, b) -> a.toUpperCase() + b.toUpperCase(),
                "Ralph ", "Kramden"
            );

            assertEquals("RALPH KRAMDEN", result);
        }
    }
}
