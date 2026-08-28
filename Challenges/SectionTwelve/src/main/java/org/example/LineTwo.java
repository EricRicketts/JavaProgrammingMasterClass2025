package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LineTwo implements Mappable<List<PointTwo>>{

    private List<PointTwo> points;
    private int scaleFactor;

    public LineTwo(List<PointTwo> points, int scaleFactor) {
        this.points = points;
        this.scaleFactor = scaleFactor;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public List<BigDecimal> getPoint(int index) {
        if (index <= this.render().size()) {
            PointTwo point = this.render().get(index);
            return point.render();
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
        List<PointTwo> renderedPoints = new ArrayList<>();
        for(PointTwo point : points) {
            renderedPoints.add(point);
        }
        return renderedPoints;
    }
}
