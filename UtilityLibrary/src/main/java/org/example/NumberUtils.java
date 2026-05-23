package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    /**
     * setScale uses the RoundingMode.HALF_UP because this rounding mode rounds to the nearest
     * numeric neighbor unless equidistant from both greater and lesser neighbors in which case
     * it rounds up.  This is the accepted behavior for rounding taught in all US schools.
     * @param value - value to be scaled
     * @param scaleFactor - desired decimal precision
     * @return scaled value at the required precision
     */
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
