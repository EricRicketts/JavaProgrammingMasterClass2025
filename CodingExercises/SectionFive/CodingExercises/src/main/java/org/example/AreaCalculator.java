package org.example;

import java.math.BigDecimal;

public class AreaCalculator {

    public static double area(double radius) {
       if (radius < 0) return -1.00;
        BigDecimal area =
                new BigDecimal(Math.PI * radius * radius).setScale(2, BigDecimal.ROUND_HALF_UP);
        return area.doubleValue();
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0) return -1.00;
        BigDecimal area =
                new BigDecimal(x * y).setScale(2, BigDecimal.ROUND_HALF_UP);
        return area.doubleValue();
    }
}
