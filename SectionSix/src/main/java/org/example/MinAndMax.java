package org.example;

import static java.lang.Double.MIN_VALUE;
import static java.lang.Double.MAX_VALUE;

public class MinAndMax {

    private Double min =  MAX_VALUE;
    private Double max = -1 * min;

    public void setMinAndMax(Double number) {
        if (number < min)  {
            min = number;
        }
        if (number > max)  {
            max = number;
        }
    }

    public void setMinAndMax(Integer number) {
        Double numberToDouble = Double.valueOf(number);
        if (numberToDouble <= min)  {
            min = numberToDouble;
        }
        if (numberToDouble >= max)  {
            max = numberToDouble;
        }
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }
}
