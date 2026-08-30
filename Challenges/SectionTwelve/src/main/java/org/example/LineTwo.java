package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineTwo implements Mappable<List<Point>>{

    private final List<Point> points;
    private int scaleFactor;

    public LineTwo(List<Point> points, int scaleFactor) {
        this.points = new ArrayList<>(points);
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public List<Point> getPoints() {
        List<Point> currentPoints = new ArrayList<>();
        for (Point point : this.points) {
            Point newPoint =
                new Point(point.getX(), point.getY(), this.scaleFactor);
            currentPoints.add(newPoint);
        }
        return currentPoints;
    }

    public Point getPoint(int index) {
        Point point = points.get(index);
        return new Point(point.getX(), point.getY(), this.scaleFactor);
    }

    public void setPoint(int index, BigDecimal x, BigDecimal y) {
        String errorMessage = "index for set point out of range";
        /*
            Alternative mutating the objects directly:
            Point point = this.points.get(index);
            point.setX(x);
            point.setY(y);
            point.setScaleFactor(this.scaleFactor);
        */
        if (index >= 0 && index < this.points.size()) {
            this.points.set(index, new Point(x, y, this.scaleFactor));
        } else {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<Point> render() {
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
        for(Point point : this.points) {
            sb.append(point.toString()).append("\n");
        }
        return sb.append("}").toString();
    }
}
