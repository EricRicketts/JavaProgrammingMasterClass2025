package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static double setScale(double value, int scaleFactor) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scaleFactor, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
