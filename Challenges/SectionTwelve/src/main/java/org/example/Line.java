package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line implements Mappable<List<List<BigDecimal>>>{

    private final List<Point> points;
    private int scaleFactor;

    public Line(List<Point> points, int scaleFactor) {
        this.points = new ArrayList<>();
        for (Point point : points) {
            this.points.add(new Point(point.getX(), point.getY()));
        }
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return this.scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public List<Point> getPoints() {
        List<Point> currentPoints = new ArrayList<>();
        for (Point point : this.points) {
            currentPoints.add(new Point(point.getX(), point.getY()));
        }
        return currentPoints;
    }

    public Point getPoint(int index) {
        return new Point(points.get(index).getX(), points.get(index).getY());
    }

    public void setPoint(int index, BigDecimal x, BigDecimal y) {
        String errorMessage = "index for set point out of range";
        if (index >= 0 && index < this.points.size()) {
            this.points.set(index, new Point(x, y));
        } else {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public List<List<BigDecimal>> render() {
        List<List<BigDecimal>> renderedPoints = new ArrayList<>();
        for (Point point : this.points) {
            BigDecimal scaledX =
                point.getX().setScale(this.scaleFactor, RoundingMode.HALF_UP);
            BigDecimal scaledY =
                point.getY().setScale(this.scaleFactor, RoundingMode.HALF_UP);
            List<BigDecimal> pointCoordinates =
                List.of(scaledX, scaledY);
            renderedPoints.add(pointCoordinates);
        }
        return renderedPoints;
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
