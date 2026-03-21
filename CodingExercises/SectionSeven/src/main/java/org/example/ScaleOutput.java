package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScaleOutput {

    public static double setScaleTo(double number, int scale) {
        BigDecimal bd = new BigDecimal(number);
        BigDecimal scaled = bd.setScale(scale, RoundingMode.HALF_UP);
        return scaled.doubleValue();
    }
}
