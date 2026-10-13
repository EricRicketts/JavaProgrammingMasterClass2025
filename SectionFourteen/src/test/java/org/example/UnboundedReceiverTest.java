package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnboundedReceiverTest {

    private int integerResult;

    @Nested
    @DisplayName("test with simple calculator")
    class TestWithSimpleCalculator {
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

    @Nested
    @DisplayName("Unbounded tests for some strings")
    class TestUnboundedTestsForSomeStrings {

        @Test
        public void testBinaryUnboundedOperator() {
            BinaryOperator<String> b = String::concat;
            String result = b.apply("Hello ", "World");

            assertEquals("Hello World", result);
        }

        @Test
        public void testBiFunctionUnboundedOperator() {
            BiFunction<String, String, String> b = String::concat;
            String result = b.apply("Hello ", "World");

            assertEquals("Hello World", result);
        }

        @Test
        public void testUnaryOperator() {
            UnaryOperator<String> b = String::toUpperCase;

            assertEquals("HELLO WORLD", b.apply("hello world"));
        }
    }
}
