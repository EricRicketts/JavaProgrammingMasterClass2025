package org.example;

import java.math.BigDecimal;

public class Square extends Rectangle {

    private BigDecimal side;

    public Square(BigDecimal side) {
        this.side = ValueValidator.validateNumberAndReturn(
                side,
                "Null value not allowed for a side",
                "Side is less than zero"
        );
    }

    public BigDecimal getSide() {
        return side;
    }

    public void setSide(BigDecimal side) {
        this.side = ValueValidator.validateNumberAndReturn(
                side,
                "Null value not allowed for a side",
                "Side is less than zero"
        );
    }

    public BigDecimal getArea() {
        return NumberUtils.setScale(
                getSide().multiply(getSide()), 2);
    }
}