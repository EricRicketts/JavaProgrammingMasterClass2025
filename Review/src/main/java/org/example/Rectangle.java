package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Rectangle {
    private final BigDecimal width;
    private final BigDecimal height;
    private final int scaleFactor;

    public Rectangle(BigDecimal width, BigDecimal height, int scaleFactor) {
        this.scaleFactor = ValueValidator.validateScaleFactor(scaleFactor);
        this.width = ValueValidator.validateAndScaleWidth(width, scaleFactor);
       this.height = ValueValidator.validateAndScaleHeight(height, scaleFactor);
    }

    public Rectangle(BigDecimal width, BigDecimal height) {
        this(width, height, 2);
    }

    public Rectangle(BigDecimal side) {
        this(side, side, 2);
    }

    public BigDecimal getWidth() {
        return width;
    }

    public BigDecimal getHeight() {
        return height;
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
                height).trim();
    }
}