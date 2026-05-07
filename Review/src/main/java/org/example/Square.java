package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Square {

    private final BigDecimal side;
    private final int scaleFactor;

    public Square(BigDecimal side, int scaleFactor) {
        this.scaleFactor = validateScaleFactor(scaleFactor);
        this.side = validateAndScaleSide(side, this.scaleFactor);
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
        return "Square[side = " + side + "]";
    }

    private BigDecimal validateAndScaleSide(BigDecimal side, int scaleFactor) {
        if (Objects.isNull(side)) {
            throw new NullPointerException(
                    ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
            );
        } else if (side.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
            );
        } else if (side.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
            );
        } else {
            return NumberUtils.setScale(side, scaleFactor);
        }
    }

    private int validateScaleFactor(int scaleFactor) {
         if (scaleFactor == 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
            );
        } else if (scaleFactor < 0) {
            throw new IllegalArgumentException(
                    ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
            );
        } else {
            return scaleFactor;
        }
    }
}