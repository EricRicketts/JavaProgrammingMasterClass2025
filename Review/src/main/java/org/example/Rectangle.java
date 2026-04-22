package org.example;

import java.math.BigDecimal;

public class Rectangle {
    private BigDecimal width, height;

    public Rectangle(BigDecimal width, BigDecimal height) {
        this.width = ValueValidator.validateNumberAndReturn(
                width,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_WIDTH.getErrorMessage()
        );

        this.height = ValueValidator.validateNumberAndReturn(
                height,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
        );
    }

    public Rectangle(BigDecimal side) {
        this(side, side);
    }

    public Rectangle() {
        this(BigDecimal.valueOf(20.00), BigDecimal.valueOf(10.00));
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

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = ValueValidator.validateNumberAndReturn(
                height,
                ErrorMessages.NULL_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage(),
                ErrorMessages.NEGATIVE_VALUE_MESSAGE_FOR_HEIGHT.getErrorMessage()
        );
    }

    public BigDecimal getArea() {
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