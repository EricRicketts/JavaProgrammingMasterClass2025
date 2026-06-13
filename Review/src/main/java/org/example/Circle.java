package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {

    private BigDecimal radius;

    private int scaleFactor;

    public Circle(BigDecimal radius, int scaleFactor) {
        this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
        this.scaleFactor = ValueValidator.validatePositiveIntAndReturn(scaleFactor, "scale factor");
    }

    public Circle() {
        this(new BigDecimal("1.54"), 2);
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = ValueValidator.validatePositiveIntAndReturn(scaleFactor, "scale factor");
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
    }

    @Override
    public BigDecimal area() {
        BigDecimal radiusSquared = this.getRadius().multiply(this.getRadius());
        BigDecimal unscaledArea = BigDecimal.valueOf(Math.PI).multiply(radiusSquared);

        return unscaledArea.setScale(scaleFactor, RoundingMode.HALF_UP);
    }

    public BigDecimal circumference() {
        BigDecimal unscaledCircumference =
            new BigDecimal("2").multiply(new BigDecimal(Math.PI)).multiply(this.getRadius());

        return unscaledCircumference.setScale(scaleFactor, RoundingMode.HALF_UP);
    }
}
