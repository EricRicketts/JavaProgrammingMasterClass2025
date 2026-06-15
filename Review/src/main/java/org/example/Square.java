package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square extends Shape {

    private BigDecimal side;
    private int scaleFactor;

    private static final String SCALE_FACTOR_ERROR_MESSAGE =
        "Scale factor is too large.";

    private static final int MAX_SCALE_FACTOR = 10;

    public Square(BigDecimal side, int scaleFactor) {
        int nonNegativeScaleFactor =
            ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
        this.scaleFactor = validateScaleFactorSize(nonNegativeScaleFactor);
        this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
    }

    public Square() {
        this(BigDecimal.valueOf(2), 2);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        int nonNegativeScaleFactor =
            ValueValidator.validateNonNegativeIntAndReturn(scaleFactor, "scale factor");
        this.scaleFactor = validateScaleFactorSize(nonNegativeScaleFactor);
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = ValueValidator.validateNonNegativeBigDecimalAndReturn(side, "side");
    }

    @Override
    public BigDecimal area() {
        BigDecimal unscaledArea = side.multiply(side);

        return unscaledArea.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    public BigDecimal perimeter() {
        BigDecimal unscaledPerimeter = BigDecimal.valueOf(4).multiply(side);

        return unscaledPerimeter.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    private int validateScaleFactorSize(int scaleFactor) {
        if (scaleFactor > MAX_SCALE_FACTOR) {
            throw new IllegalArgumentException(SCALE_FACTOR_ERROR_MESSAGE);
        } else {
            return scaleFactor;
        }
    }
}