package org.example;

import java.math.BigDecimal;

public class Rectangle {

    private BigDecimal length;
    private BigDecimal width;

    public BigDecimal getLength() {
        return length;
    }

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

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
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
