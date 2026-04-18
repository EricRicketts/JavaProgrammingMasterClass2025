package org.example;

import java.math.BigDecimal;

public class Square extends Rectangle {

    private BigDecimal side;

    public Square(BigDecimal side) {
        this.side = this.validateAmountAndReturn(
                side,
                "Null value not allowed for a side",
                "Side is less than zero"
        );
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = this.validateAmountAndReturn(
                side,
                "Null value not allowed for a side",
                "Side is less than zero"
        );
    }

    public BigDecimal getArea() {
        BigDecimal area = getSide().multiply(getSide());
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
