package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static BigDecimal setScale(BigDecimal value, int scaleFactor) {
        return value.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    public static int checkNumberInRangeAndReturn(
            int number,
            int lower,
            int upper,
            String lowerBoundErrorMessage,
            String upperBoundErrorMessage
    ) {
        if (number < lower) {
            throw new IllegalArgumentException(lowerBoundErrorMessage);
        } else if (number > upper) {
            throw new IllegalArgumentException(upperBoundErrorMessage);
        }
        return number;
    }
}
