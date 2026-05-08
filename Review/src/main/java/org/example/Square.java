package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Square {

    private final BigDecimal side;
    private final int scaleFactor;

    public Square(BigDecimal side, int scaleFactor) {
        this.scaleFactor = ValueValidator.validateScaleFactor(scaleFactor);
        this.side = ValueValidator.validateAndScaleSide(side, this.scaleFactor);
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
}