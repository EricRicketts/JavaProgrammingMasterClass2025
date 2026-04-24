package org.example;

import java.math.BigDecimal;

public class Rectangle {
    private final BigDecimal width;
    private final BigDecimal height;

    public Rectangle(BigDecimal width, BigDecimal height, int scaleFactor) {
        scaleFactor = validateScaleFactor(scaleFactor);
        this.width = validateWidth(width, scaleFactor);
        this.height = validateHeight(height, scaleFactor);
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

    public BigDecimal area(int scaleFactor) {

        return NumberUtils.setScale(
                (getWidth().multiply(getHeight())), scaleFactor);
    }

    private BigDecimal validateWidth(BigDecimal width, int scaleFactor) {
        ValueValidator.checkForNull(
                width,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );
        ValueValidator.checkForNegativeValue(
                width,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );
        return NumberUtils.setScale(width, scaleFactor);
    }

    private BigDecimal validateHeight(BigDecimal height, int scaleFactor) {
        ValueValidator.checkForNull(
                height,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
        );
        ValueValidator.checkForNegativeValue(
                height,
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
        );
        return NumberUtils.setScale(height, scaleFactor);
    }

    private int validateScaleFactor(int scaleFactor) {
        return ValueValidator.checkForNegativeOrZeroValue(
                scaleFactor,
                ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );
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