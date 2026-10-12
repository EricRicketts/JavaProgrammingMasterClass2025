package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaExpressionAndMethodReferenceTest {
    private static <T> T calculator(BinaryOperator <T> function, T firstValue, T secondValue) {
        return function.apply(firstValue, secondValue);
    }

    private static BigDecimal divideWithPrecision(BigDecimal a, BigDecimal b) {
        return a.divide(b, MathContext.DECIMAL128);
    }

    private List<String> names = new ArrayList<>(
        List.of(
            "Anna", "Bob", "Chuck", "Dale", "Ernest", "Frederick", "George"
        )
    );

    @Nested
    @DisplayName("test calculator with Integers")
    class TestCalculatorWithIntegers {

        @Test
        public void testCalculatorWithAdditionOfIntegers() {
            Integer result = calculator((a, b) -> a + b, 10, 12);
            assertEquals(22, result);
        }

        @Test
        public void testCalculatorWithAdditionOfIntegersMethodReference() {
            Integer result = calculator(Integer::sum, 10, 12);
            assertEquals(22, result);
        }

        @Test
        public void testCalculatorWithSubtractionOfIntegers() {
            Integer result = calculator((a, b) -> a - b, 5, 10);
            assertEquals(-5, result);
        }

        @Test
        public void testCalculatorWithSubtractionOfIntegersMethodReference() {
            BigInteger result = calculator(BigInteger::subtract, BigInteger.valueOf(5), BigInteger.valueOf(10));
            assertEquals(BigInteger.valueOf(-5), result);
        }

        @Test
        public void testCalculatorWithMultiplicationOfIntegers() {
            Integer result = calculator((a, b) -> a * b, 5, 5);
            assertEquals(25, result);
        }

        @Test
        public void testCalculatorWithMultiplicationOfIntegersMethodReference() {
            BigInteger result = calculator(BigInteger::multiply, BigInteger.valueOf(5), BigInteger.valueOf(5));
            assertEquals(BigInteger.valueOf(25), result);
        }

        @Test
        public void testCalculatorWithDivisionOfIntegers() {
            Integer result = calculator((a, b) -> a / b, 23, 5);
            assertEquals(4, result);
        }

        @Test
        public void testCalculatorWithDivisionOfIntegersMethodReference() {
            BigInteger result = calculator(BigInteger::divide, BigInteger.valueOf(23), BigInteger.valueOf(5));
            assertEquals(BigInteger.valueOf(4), result);
        }
    }

    @Nested
    @DisplayName("test calculator with Big Decimals")
    class TestCalculatorWithBigDecimals {

        @Test
        public void testCalculatorWithAdditionOfBigDecimals() {
            BigDecimal result = calculator(
                (a, b) -> a.add(b),
                new BigDecimal("12.34"), new BigDecimal("7.89"));
            assertEquals(new BigDecimal("20.23"), result);
        }

        @Test
        public void testCalculatorWithAdditionOfBigDecimalsMethodReference() {
            BigDecimal result = calculator(
                BigDecimal::add,
                new BigDecimal("12.34"), new BigDecimal("7.89"));
            assertEquals(new BigDecimal("20.23"), result);
        }

        @Test
        public void testCalculatorWithSubtractionOfBigDecimals() {
            BigDecimal result = calculator(
                (a, b) -> a.subtract(b),
                new BigDecimal("5.23"), new BigDecimal("46.67"));
            assertEquals(new BigDecimal("-41.44"), result);
        }

        @Test
        public void testCalculatorWithSubtractionOfBigDecimalsMethodReference() {
            BigDecimal result = calculator(
                BigDecimal::subtract,
                new BigDecimal("5.23"), new BigDecimal("46.67"));
            assertEquals(new BigDecimal("-41.44"), result);
        }

        @Test
        public void testCalculatorWithMultiplicationOfBigDecimals() {
            BigDecimal result = calculator(
                (a, b) -> a.multiply(b, MathContext.DECIMAL128),
                new BigDecimal("23.28"), new BigDecimal("11.49"));
            result = result.setScale(2, RoundingMode.HALF_UP);
            assertEquals(new BigDecimal("267.49"), result);
        }

        @Test
        public void testCalculatorWithMultiplicationOfBigDecimalsMethodReference() {
            BigDecimal result = calculator(
                BigDecimal::multiply,
                new BigDecimal("23.28"), new BigDecimal("11.49"));
            result = result.setScale(2, RoundingMode.HALF_UP);
            assertEquals(new BigDecimal("267.49"), result);
        }

        @Test
        public void testCalculatorWithDivisionOfBigDecimals() {
            BigDecimal result = calculator(
                (a, b) -> a.divide(b, MathContext.DECIMAL128),
                new BigDecimal("230.67"), new BigDecimal("51.89"));
            result = result.setScale(2, RoundingMode.HALF_UP);
            assertEquals(new BigDecimal("4.45"), result);
        }

        @Test
        public void testCalculatorWithDivisionOfBigDecimalsMethodReference() {
            /*
               LambdaExpressionAndMethodReferenceTest is the name of this test class,
               and divideWithPrecision is the private method I defined, so I instantiated
               my own custom method reference.  divideWithPrecision takes to arguments,
               and Java looked at the lambda expression defined in the calculator method by
               the BinaryOperator function argument.
            */
            BigDecimal result = calculator(
                LambdaExpressionAndMethodReferenceTest::divideWithPrecision,
                new BigDecimal("230.67"), new BigDecimal("51.89"));
            result = result.setScale(2, RoundingMode.HALF_UP);
            assertEquals(new BigDecimal("4.45"), result);
        }
    }

    @Test
    public void testLambdaReverseEachStringInList() {
        List<String> reversedNames = new ArrayList<>();

    }
}
