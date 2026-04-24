package org.example;

import java.math.BigDecimal;

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
        ValueValidator.validateNumberAndReturn(
                side,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );
        return NumberUtils.setScale(side, scaleFactor);
    }

    private int validateScaleFactor(int scaleFactor) {
        return ValueValidator.checkForNegativeOrZeroValue(
                scaleFactor,
                ErrorMessages.NEGATIVE_OR_ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );
    }
}