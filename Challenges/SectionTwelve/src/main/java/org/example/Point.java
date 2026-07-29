package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Point implements Mappable {

    private BigDecimal x;
    private BigDecimal y;
    private int precision;

    public Point(BigDecimal x, BigDecimal y, int precision) {
        this.precision = precision;
        this.x = this.round(x);
        this.y = this.round(y);
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = this.round(x);
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = this.round(y);
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    private BigDecimal round(BigDecimal value) {
        return value.setScale(this.getPrecision(), RoundingMode.HALF_UP);
    }

    @Override
    public List<BigDecimal> render() {
        return new ArrayList<BigDecimal>(List.of(this.getX(), this.getY()));
    }

    @Override
    public String toString() {
        StringBuilder coordinates = new StringBuilder();
        coordinates.append("[").append(this.getX()).append(", ")
            .append(this.getY()).append("]");

        return coordinates.toString();
    }
}
