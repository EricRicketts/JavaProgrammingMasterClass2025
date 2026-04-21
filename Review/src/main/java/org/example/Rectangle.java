package org.example;

import java.math.BigDecimal;

public class Rectangle {
    private BigDecimal length, width;
    private Square square;

    public Rectangle(BigDecimal length, BigDecimal width) {
        this.length = ValueValidator.validateNumberAndReturn(
                length,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_LENGTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_LENGTH.getErrorMessage()
        );

        this.width = ValueValidator.validateNumberAndReturn(
                width,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );

        if (length.equals(width)) {
            this.square = new Square(length);
        }
    }

    public Rectangle(BigDecimal side) {
        this.square = new Square(side);
    }

    public Rectangle() {
        this(BigDecimal.valueOf(20.00), BigDecimal.valueOf(10.00));
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(BigDecimal side) {
        this.square = new Square(side);
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = ValueValidator.validateNumberAndReturn(
                length,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_LENGTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_LENGTH.getErrorMessage()
        );
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = ValueValidator.validateNumberAndReturn(
                width,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );
    }

    public BigDecimal getArea() {
        return NumberUtils.setScale(
                getLength().multiply(getWidth()), 2);
    }
}
