package org.example;

import java.math.BigDecimal;
import java.util.Random;

public class LPAStudent extends ThirdStudent {

    private BigDecimal percentComplete;

    public LPAStudent() {
        Random random = new Random();
        this.percentComplete = BigDecimal.valueOf(random.nextDouble(0, 100.001));
    }

    public BigDecimal getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), this.getPercentComplete());
    }
}
