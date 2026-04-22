package org.example;

import java.math.BigDecimal;

public class Square extends Rectangle {

    private BigDecimal side;

    public Square(BigDecimal side) {
        this.side = ValueValidator.validateNumberAndReturn(
                side,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = ValueValidator.validateNumberAndReturn(
                side,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_SIDE.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_SIDE.getErrorMessage()
        );
    }

    public BigDecimal getArea() {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), 2);
    }

    @Override
    public String toString() {
        return "Square[side = " + side + "]";
    }
}