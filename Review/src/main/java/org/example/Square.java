package org.example;

import java.math.BigDecimal;

public class Square {

    private final BigDecimal side;

    public Square(BigDecimal side, int scaleFactor) {
        this.side = ValueValidator.validateNumberAndReturn(
                side,
                scaleFactor,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );
    }

    public BigDecimal getSide() {
        return side;
    }

    public BigDecimal area() {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), 2);
    }

    @Override
    public String toString() {
        return "Square[side = " + side + "]";
    }
}