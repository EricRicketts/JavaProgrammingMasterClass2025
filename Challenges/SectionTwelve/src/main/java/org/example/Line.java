package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line implements Mappable<List<Point>>{

    private final List<Point> points;
    private int scaleFactor;

    public Line(List<Point> points, int scaleFactor) {
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
        List<Point> renderedRiver = new ArrayList<>();
        renderedRiver.addAll(points);
        return renderedRiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(this.points, line.points) &&
            this.scaleFactor == line.scaleFactor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.points, this.scaleFactor);
    }

    @Override
    public String toString() {
        String output = this.getClass().getSimpleName() + ":" + "\n" + "{" + "\n";
        List<Point> list = new ArrayList<>(points);

        String interiorString = list.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(",\n"));

        return output.concat(interiorString).concat("\n").concat("}");
    }
}
