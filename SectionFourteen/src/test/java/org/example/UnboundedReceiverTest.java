package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

            String result = "hello world".transform(b);
            assertEquals("HELLO WORLD", result);
        }

        @Test
        public void testUnaryOperatorAndToLowerCase() {
            UnaryOperator<String> b = String::toLowerCase;

            String result = "HELLO WORLD".transform(String::toLowerCase);
            assertEquals("hello world", result);

            // In the code below a function is defined with String for the input type
            // and Boolean for the return type.  When f0 is sent as an argument to
            // transform, "result" is the input and boolean strToBool is where the
            // output is captured.
            Function<String, Boolean> f0 = String::isEmpty;
            boolean strToBool = result.transform(f0);
            assertFalse(strToBool);
        }
    }
}
