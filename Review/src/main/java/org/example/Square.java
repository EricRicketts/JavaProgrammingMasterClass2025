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
        BigDecimal nonNullSide = ValueValidator.checkForNullValueAndReturn(
                side,
                ErrorMessage.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );

        BigDecimal nonNegativeSide = ValueValidator.checkForNegativeValueAndReturn(
                nonNullSide,
                ErrorMessage.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );

        return NumberUtils.setScale(nonNegativeSide, scaleFactor);
    }

    private int validateScaleFactor(int scaleFactor) {
        int nonZeroScaleFactor = ValueValidator.checkForZeroValueAndReturn(
                scaleFactor,
                ErrorMessage.ZERO_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );

        return ValueValidator.checkForNegativeValueAndReturn(
                nonZeroScaleFactor,
                ErrorMessage.NEGATIVE_VALUE_MESSAGE_FOR_SCALE_FACTOR.getErrorMessage()
        );
    }
}