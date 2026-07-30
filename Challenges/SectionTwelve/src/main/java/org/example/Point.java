package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Point implements Mappable<List<BigDecimal>> {

    private BigDecimal x;
    private BigDecimal y;

    public Point(BigDecimal x, BigDecimal y, int precision) {
        this.x = this.round(x, precision);
        this.y = this.round(y, precision);
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x, int precision) {
        this.x = this.round(x, precision);
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y, int precision) {
        this.y = this.round(y, precision);
    }

    private BigDecimal round(BigDecimal value, int precision) {
        return value.setScale(precision, RoundingMode.HALF_UP);
    }

    @Override
    public List<BigDecimal> render() {
        return Arrays.asList(this.x, this.y);
    }

    @Override
    public String toString() {
        StringBuilder coordinates = new StringBuilder();
        coordinates.append("[").append(this.getX()).append(", ")
            .append(this.getY()).append("]");

        return coordinates.toString();
    }
}
