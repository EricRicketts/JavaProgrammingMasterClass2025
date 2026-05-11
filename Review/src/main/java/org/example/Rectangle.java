package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Rectangle {
    private final BigDecimal width;

    private final BigDecimal height;

    private final int scaleFactor;

    public Rectangle(BigDecimal width, BigDecimal height, int scaleFactor) {
        this.height = validateHeightAndReturn(height);
        this.scaleFactor = validateScaleFactor(scaleFactor);
        this.width = validateWidthAndReturn(width);
    }

    public Rectangle(BigDecimal width, BigDecimal height) {
        this(width, height, 2);
    }

    public Rectangle(BigDecimal side) {
        this(side, side, 2);
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public BigDecimal area() {

        return NumberUtils.setScale(
                (getWidth().multiply(getHeight())), scaleFactor);
    }


    @Override
    public String toString() {
        String scaledDimension = "%." + scaleFactor + "f%n";
        return String.format(
                "Rectangle:%n" +
                "width = " + scaledDimension +
                "height = " + scaledDimension,
                width,
                height
        ).trim();
    }

    public BigDecimal validateHeightAndReturn(BigDecimal height) {
        BigDecimal validHeight = ValueValidator.validatePositiveBigDecimalAndReturn(height, "height");
        return NumberUtils.setScale(validHeight, this.scaleFactor);
    }

    public int validateScaleFactor(int scaleFactor) {
        return ValueValidator.validatePositiveIntAndReturn(scaleFactor, "scale factor");
    }

    public BigDecimal validateWidthAndReturn(BigDecimal width) {
        BigDecimal validWidth = ValueValidator.validatePositiveBigDecimalAndReturn(width, "width");
        return NumberUtils.setScale(validWidth, this.scaleFactor);
    }
}