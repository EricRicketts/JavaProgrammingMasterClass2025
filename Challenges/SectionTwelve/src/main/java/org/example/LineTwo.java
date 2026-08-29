package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineTwo implements Mappable<List<PointTwo>>{

    private final List<PointTwo> points;
    private int scaleFactor;

    public LineTwo(List<PointTwo> points, int scaleFactor) {
        for (PointTwo point : points) point.setScaleFactor(scaleFactor);
        this.points = points;
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public List<PointTwo> getPoints() {
        return points;
    }

    public PointTwo getPoint(int index) {
        if (index <= this.render().size()) {
            return this.render().get(index);
        }
        return null;
    }

    public void setPoint(int index, BigDecimal x, BigDecimal y) {
        if (index <= this.render().size()) {
            PointTwo point = this.render().get(index);
            point.setX(x);
            point.setY(y);
        }
    }

    public List<PointTwo> render() {
        return new ArrayList<>(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        LineTwo line = (LineTwo) o;
        return Objects.equals(this.points, line.points) &&
            this.scaleFactor == line.scaleFactor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.points, this.scaleFactor);
    }
}
