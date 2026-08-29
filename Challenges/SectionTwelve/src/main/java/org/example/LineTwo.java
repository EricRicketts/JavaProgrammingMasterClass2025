package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineTwo implements Mappable<List<PointTwo>>{

    private final List<PointTwo> points;
    private int scaleFactor;

    public LineTwo(List<PointTwo> points, int scaleFactor) {
        this.points = new ArrayList<>(points);
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public List<PointTwo> getPoints() {
        List<PointTwo> currentPoints = new ArrayList<>();
        for (PointTwo point : this.points) {
            PointTwo newPoint =
                new PointTwo(point.getX(), point.getY(), this.scaleFactor);
            currentPoints.add(newPoint);
        }
        return currentPoints;
    }

    public PointTwo getPoint(int index) {
        PointTwo point = points.get(index);
        return new PointTwo(point.getX(), point.getY(), this.scaleFactor);
    }

    public void setPoint(int index, BigDecimal x, BigDecimal y) {
        String errorMessage = "index for set point out of range";
        /*
            Alternative mutating the objects directly:
            PointTwo point = this.points.get(index);
            point.setX(x);
            point.setY(y);
            point.setScaleFactor(this.scaleFactor);
        */
        if (index >= 0 && index < this.points.size()) {
            this.points.set(index, new PointTwo(x, y, this.scaleFactor));
        } else {
            throw new IllegalArgumentException(errorMessage);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Line:").append("\n").append("{").append("\n");
        for(PointTwo point : this.points) {
            sb.append(point.toString()).append("\n");
        }
        return sb.append("}").toString();
    }
}
