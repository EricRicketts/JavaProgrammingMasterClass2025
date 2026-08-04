package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class LPAStudent extends ThirdStudent {

    private BigDecimal percentComplete;

    public LPAStudent() {
        Random random = new Random();
        this.percentComplete = new BigDecimal(
            random.nextDouble(0.00, 100.001)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }

    @Override
    public String toString() {
        return "%s %8.2f%%".formatted(super.toString(), this.getPercentComplete());
    }
}
