package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static BigDecimal setScale(BigDecimal value, int scaleFactor) {
        return value.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    public static int checkNumberRangeAndReturn(
            int number,
            int lower,
            int upper,
            String errorMessage
    ) {
        if (number < lower || number > upper) {
            throw new IllegalArgumentException(errorMessage);
        }
        return number;
    }
}
