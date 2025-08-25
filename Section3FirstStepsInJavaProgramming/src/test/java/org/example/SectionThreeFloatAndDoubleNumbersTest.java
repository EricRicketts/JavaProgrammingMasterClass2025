package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SectionThreeFloatAndDoubleNumbersTest {

    Float expectedFloat;
    Double expectedDouble;

    @Test
    void testFloatVariable() {
        // had to declare Float because default decimal format is Double
        expectedFloat = 5.25F;
        float  myFloatVariable = 5.25F;
        Assertions.assertEquals(myFloatVariable, expectedFloat);
    }

    @Test
    void testDoubleVariable() {
        // since Double is default for decimal numbers no need to use "d" or "D" suffix
        expectedDouble = 5.25D;
        double  myDoubleVariable = 5.25D;
        Assertions.assertEquals(myDoubleVariable, expectedDouble);
    }

    @Test
    void testCastingForAFloat() {
        // note we did the cast because the default real number type is double
        // obviously casting is too wordy, better is just standard type declaration
        // expectedFloat = 5.25F;
        expectedFloat = (float) 5.25;
        float  myFloatVariable = (float) 5.25;
        Assertions.assertEquals(myFloatVariable, expectedFloat);
    }

    @Test
    void testSimpleIntegerDivision() {
        // for integer division Java does some special rounding
        int firstInteger = 5;
        int secondInteger = 2;
        int thirdInteger = 3;
        Assertions.assertEquals(secondInteger, firstInteger / secondInteger);
        Assertions.assertEquals(1, firstInteger / thirdInteger);
    }

    @Test
    void testSimpleDoubleDivision() {
        Double firstDouble = 5.00;
        Double secondDouble = 3.00;
        BigDecimal answer;
        answer = BigDecimal.valueOf(1.0 + 2.0 / 3.0);
        BigDecimal truncatedAnswer = answer.setScale(6, RoundingMode.DOWN);
        BigDecimal bigDecimalNumber = BigDecimal.valueOf(firstDouble / secondDouble);
        BigDecimal bigDecimalNumberTruncated = bigDecimalNumber.setScale(6, RoundingMode.DOWN);
        Assertions.assertEquals(truncatedAnswer,  bigDecimalNumberTruncated);
    }
}
