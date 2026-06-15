package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Square extends Shape {

    private BigDecimal side;
    private int scaleFactor;

    public Square(BigDecimal side, int scaleFactor) {
        this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
        this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
    }

    public Square() {
        this(BigDecimal.valueOf(2), 2);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
    }

    @Override
    public BigDecimal area() {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), scaleFactor);
    }

    public BigDecimal perimeter() {
        return NumberUtils.setScale(BigDecimal.valueOf(4).multiply(side), scaleFactor);
    }
}