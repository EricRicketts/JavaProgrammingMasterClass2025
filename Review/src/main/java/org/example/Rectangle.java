package org.example;

import java.math.BigDecimal;

public class Rectangle {
    private final BigDecimal width;
    private final BigDecimal height;

    public Rectangle(BigDecimal width, BigDecimal height, int scaleFactor) {
        this.width = ValueValidator.validateNumberAndReturn(
                width,
                scaleFactor,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );

        this.height = ValueValidator.validateNumberAndReturn(
                height,
                scaleFactor,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
        );
    }

    public Rectangle(BigDecimal side, int scaleFactor) {
        this(side, side, scaleFactor);
    }

    public BigDecimal getWidth() {
        return width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal area() {
        return NumberUtils.setScale(
                getHeight().multiply(getWidth()), 2);
    }

    @Override
    public String toString() {
        return "Rectangle[width = " +
                width +
                ", height = " +
                height +
                "]";
    }
}