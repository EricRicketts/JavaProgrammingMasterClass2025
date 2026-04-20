package org.example;

import java.math.BigDecimal;

public class Rectangle {

    private BigDecimal length;
    private BigDecimal width;

    public Rectangle(BigDecimal length, BigDecimal width) {
        this.length = ValueValidator.validateNumberAndReturn(
                length,
                "Null value not allowed for length",
                "Length is less than zero"
        );

        this.width = ValueValidator.validateNumberAndReturn(
                width,
                "Null value not allowed for width",
                "Width is less than zero"
        );
    }

    public Rectangle(BigDecimal side) {
        this(side, side);
    }

    public Rectangle() {
        this(BigDecimal.valueOf(20.00), BigDecimal.valueOf(10.00));
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = ValueValidator.validateNumberAndReturn(
                length,
                "Null value not allowed for length",
                "Length is less than zero"
        );
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = ValueValidator.validateNumberAndReturn(
                width,
                "Null value not allowed for width",
                "Width is less than zero"
        );
    }

    public BigDecimal getArea() {
        return NumberUtils.setScale(
                getLength().multiply(getWidth()), 2);
    }
}
