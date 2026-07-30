package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Line implements Mappable<List<List<BigDecimal>>> {
    private List<Point> points;
    private int precision;

    public Line(ArrayList<Point> points, int precision) {
        this.precision = precision;
        this.points = new ArrayList<>();
        for (Point point : points) {
            this.addPoint(point);
        }
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
        for (Point point : this.points) {
            point.setX(point.getX(), precision);
            point.setY(point.getY(), precision);
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        point.setX(point.getX(), this.precision);
        point.setY(point.getY(), this.precision);
        this.points.add(point);
    }

    public Point getOnePoint(int index) {
        if (index >= 0 && index < this.getPoints().size()) return points.get(index);
        return null;
    }

    @Override
    public List<List<BigDecimal>> render() {
        List<List<BigDecimal>> listOfPoints = new ArrayList<>();
        for (Point point : this.getPoints()) {
            listOfPoints.add(point.render());
        }
            return listOfPoints;
    }
}