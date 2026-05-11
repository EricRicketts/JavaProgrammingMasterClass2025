package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Square {

    private final BigDecimal side;
    private final int scaleFactor;

    public Square(BigDecimal side, int scaleFactor) {
        this.scaleFactor = ValueValidator.validatePositiveIntAndReturn(scaleFactor, "scale factor");
        this.side = validateSideAndReturn(side);
    }

    public BigDecimal getSide() {
        return side;
    }

    public BigDecimal area() {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), scaleFactor);
    }

    @Override
    public String toString() {
        String scaledDimension = "%." + scaleFactor + "f%n";
        return String.format(
                "Square:%n" +
                "side = " + scaledDimension,
                side
        ).trim();
    }

    private BigDecimal validateSideAndReturn(BigDecimal side) {
        return NumberUtils.setScale(
                ValueValidator.validatePositiveBigDecimalAndReturn(side, "side"),
                this.scaleFactor
        );
    }
}