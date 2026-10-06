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
        // Looking at the arguments, they are functionally typed; value1 and value2 are typed
        // according to what is specified as T, during the call to calculator.  Note
        // Operation <T> is a call to the Operation interface, which has been defined in
        // the main executable path.
        return function.operate(value1, value2);
    }

    @Nested
    @DisplayName("test integer operations")
    class TestIntegerOperations {

        private int firstResult, secondResult;

        @Test
        public void testIntegerAddition() {
            // The warning below is the IDE suggesting to use a method reference.
            // Note the pink icons next to the left of the lambda expressions, hovering
            // over them the pop-up says, "Overrides method in Operation".  Clicking the icon
            // takes one to the Operation Interface.
            firstResult = calculator((a, b) -> a + b,  5, 2);
            secondResult = calculator(Integer::sum, 5, 2);

            assertEquals(7, firstResult);
            assertEquals(firstResult, secondResult);
        }

        @Test
        public void testIntegerSubtraction() {
            // In Java a functional reference of two or more parameters must use
            // parentheses.  Below there is no equivalent for subtraction, so for
            firstResult = calculator((a, b) -> a - b, 7, 3);
            secondResult = calculator(Integer::sum, 7, -3);

            assertEquals(4, firstResult);
            assertEquals(4, secondResult);
        }

        @Test
        public void testIntegerMultiplication() {
            firstResult = calculator((a, b) -> a * b, 5, 3);
            secondResult = calculator(Math::multiplyExact, 5, 3);

            assertEquals(15, firstResult);
            assertEquals(15, secondResult);
        }

        @Test
        public void testIntegerDivision() {
            firstResult = calculator((a, b) -> a / b, 10, 2);
            secondResult = calculator(Math::divideExact, 10, 2);

            assertEquals(5, firstResult);
            assertEquals(5, secondResult);

        }
    }

    @Nested
    @DisplayName("test BigDecimal operations")
    class TestBigDecimalOperations {

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
    }

    @Nested
    @DisplayName("test miscellaneous operations")
    class TestMiscellaneousOperations {

        @Test
        public void testCalculatorWithStrings() {
            String result = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden"
            );

            assertEquals("RALPH KRAMDEN", result);
        }

        @Test
        public void testCalculatorWithAnotherSetOfStringArguments() {
            String result = calculator(
                (a, b) -> a.concat(b), "Bugs" + " ", "Bunny");

            assertEquals("Bugs Bunny", result);

            result = calculator(
                String::concat, "Daffy ", "Duck");

            assertEquals("Daffy Duck", result);
        }

        @Test
        public void testCalculatorWithExplicitTypeAndVar() {
            int firstResult = calculator((Integer a, Integer b) -> a + b, 5, 2);
            int secondResult = calculator((var a, var b) -> a + b, 5, 2);

            assertEquals(7, firstResult);
            assertEquals(7, secondResult);
        }
    }
 }
