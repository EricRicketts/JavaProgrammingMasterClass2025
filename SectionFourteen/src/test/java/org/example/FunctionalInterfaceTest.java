package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalInterfaceTest {

    BigDecimal result;

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        // This is a functional interface, but it is manually created.  In other code and
        // tests we will look at Java's built-in functional interfaces.
        // Note a functional interface in Java is an interface that contains exactly one
        // abstract method, making it suitable for use with lambdas and method references.
        return function.operate(value1, value2);
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
        public void testCalculatorWithBigDecimalAdd() {
            result = calculator(
                (a, b) -> a.add(b),
                new BigDecimal("7.55"), new BigDecimal("6.65")
            );
            result = result.setScale(2, RoundingMode.HALF_UP);

            assertEquals(new BigDecimal("14.20"), result);
        }

        @Test
        public void testCalculatorWithBigDecimalSubtract() {
            result = calculator(
                (a, b) -> a.subtract(b),
                new BigDecimal("7.23"), new BigDecimal("4.78")
            );
            result = result.setScale(2, RoundingMode.HALF_UP);

            assertEquals(new BigDecimal("2.45"), result);
        }

        @Test
        public void testCalculatorWithBigDecimalMultiply() {
            result = calculator(
                (a, b) -> a.multiply(b),
                new BigDecimal("5.67"), new BigDecimal("3.34")
            );
            result = result.setScale(2, RoundingMode.HALF_UP);

            assertEquals(new BigDecimal("18.94"), result);
        }

        @Test
        public void testCalculatorWithBigDecimalDivide() {
            // The additional argument is needed to avoid the following error:
            // java.lang.ArithmeticException: Non-terminating decimal expansion;
            // no exact representable decimal result.
            result = calculator(
                (a, b) -> a.divide(b, MathContext.DECIMAL128),
                new BigDecimal("10.45"), new BigDecimal("2.83")
            );
            result = result.setScale(2, RoundingMode.HALF_UP);

            assertEquals(new BigDecimal("3.69"), result);
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
