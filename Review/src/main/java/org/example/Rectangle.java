package org.example;

import java.math.BigDecimal;

public class Rectangle {

    private BigDecimal length;
    private BigDecimal width;

    public Rectangle(BigDecimal length, BigDecimal width) {
        this.length = this.validateAmountAndReturn(
                length,
                "Null value not allowed for length",
                "Length is less than zero"
        );

        this.width = this.validateAmountAndReturn(
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
        this.length = this.validateAmountAndReturn(
                length,
                "Null value not allowed for length",
                "Length is less than zero"
        );
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = this.validateAmountAndReturn(
                width,
                "Null value not allowed for width",
                "Width is less than zero"
        );
    }

    public BigDecimal getArea() {
        BigDecimal area = getLength().multiply(getWidth());
        return NumberUtils.setScale(area, 2);
    }

    private BigDecimal validateAmountAndReturn(
            BigDecimal amount,
            String nullMessage,
            String negativeMessage
    ) {
        ValueValidator.checkForNull(amount, nullMessage);
        ValueValidator.checkForNegativeValue(amount, negativeMessage);
        return amount;
    }
}
