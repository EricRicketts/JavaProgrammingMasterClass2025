package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static BigDecimal setScale(BigDecimal value, int scaleFactor) {
        return value.setScale(scaleFactor, RoundingMode.HALF_UP);
    }
}
