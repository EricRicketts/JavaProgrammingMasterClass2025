package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class LPAStudent extends SecondStudent {

    private BigDecimal percentComplete;

    public LPAStudent(String lastName, String firstName, String course, int yearStarted) {
        super(lastName, firstName, course, yearStarted);
        Random random = new Random();
        percentComplete =
            BigDecimal.valueOf(random.nextDouble(0, 100.001))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }
}
