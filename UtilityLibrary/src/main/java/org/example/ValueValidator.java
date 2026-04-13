package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValueValidator {

    public static double setScale(double value, int scaleFactor) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scaleFactor, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int checkForNegativeValue(int number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

    public static double checkForNegativeValue(double number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
        return number;
    }

}
