package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Rectangle {
    private final BigDecimal width;
    private final BigDecimal height;
    private final int scaleFactor;

    public Rectangle(BigDecimal width, BigDecimal height, int scaleFactor) {
        this.scaleFactor = validateScaleFactor(scaleFactor);
        this.width = validateAndScaleWidth(width, this.scaleFactor);
       this.height = validateAndScaleHeight(height, this.scaleFactor);
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

    private BigDecimal validateAndScaleWidth(BigDecimal width, int scaleFactor) {
        if (Objects.isNull(width)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else if (width.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else if (width.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
            );
        } else {
            return NumberUtils.setScale(width, scaleFactor);
        }
    }

    private BigDecimal validateAndScaleHeight(BigDecimal height, int scaleFactor) {
        if (Objects.isNull(height)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else if (height.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else if (height.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
            );
        } else {
            return NumberUtils.setScale(height, scaleFactor);
        }
    }

    private int validateScaleFactor(int scaleFactor) {
       int nonZeroScaleFactor =
               ValueValidator.checkForZeroValueAndReturn(
                scaleFactor,
                ErrorMessages.ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );

       return ValueValidator.checkForNegativeValueAndReturn(
               nonZeroScaleFactor,
               ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
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