package org.example;

import java.math.BigDecimal;

public class Square {

    private final BigDecimal side;

    public Square(BigDecimal side, int scaleFactor) {
        this.side = validateSide(side);
    }

    public BigDecimal getSide() {
        return side;
    }

    public BigDecimal area(int scaleFactor) {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), scaleFactor);
    }

    @Override
    public String toString() {
        return "Square[side = " + side + "]";
    }

    private BigDecimal validateSide(BigDecimal side) {
        ValueValidator.validateNumberAndReturn(
                side,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );
        return side;
    }
}