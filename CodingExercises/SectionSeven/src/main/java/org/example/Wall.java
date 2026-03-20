package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wall {

    private double width, height;

    public Wall(){}

    public Wall(double width, double height) {
        width = this.scaleDimensionToTwoDecimals(width);
        height = this.scaleDimensionToTwoDecimals(height);
        this.width = (width < 0) ? 0 : width;
        this.height = (height < 0) ? 0 : height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        width = this.scaleDimensionToTwoDecimals(width);
        this.width = (width < 0) ? 0 : width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        height = this.scaleDimensionToTwoDecimals(height);
        this.height = (height < 0) ? 0 : height;
    }

    public double getArea() {
        double area = this.width * this.height;
        return this.scaleDimensionToTwoDecimals(area);
    }

    private double scaleDimensionToTwoDecimals(double dimension) {
        BigDecimal bdDimension =
                new BigDecimal(Double.toString(dimension));
        BigDecimal scaledDimension = bdDimension.setScale(2, RoundingMode.HALF_UP);
        return scaledDimension.doubleValue();
    }
}
