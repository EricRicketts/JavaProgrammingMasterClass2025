package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PointTwo implements MappableTwo<List<BigDecimal>> {

    private BigDecimal x;
    private BigDecimal y;
    int scaleFactor;

    public PointTwo(BigDecimal x, BigDecimal y, int scaleFactor) {
        this.x = x;
        this.y = y;
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public BigDecimal getX() {
        return this.x.setScale(this.getScaleFactor(), RoundingMode.HALF_UP);
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return this.y.setScale(this.getScaleFactor(), RoundingMode.HALF_UP);
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public List<BigDecimal> render() {
        return new ArrayList<>(List.of(this.getX(), this.getY()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        PointTwo point = (PointTwo) o;
        return Objects.equals(this.getX(), point.getX()) &&
            Objects.equals(this.getY(), point.getY()) &&
            this.scaleFactor == point.getScaleFactor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getScaleFactor());
    }
}
