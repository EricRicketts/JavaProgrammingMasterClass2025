package org.example;

import java.math.BigDecimal;

public class Circle extends Shape {

    private BigDecimal radius;

    public Circle(BigDecimal radius) {
        this.radius = ValueValidator.validateNonNegativeBigDecimalAndReturn(radius, "radius");
    }

    public Circle() {
        this(new BigDecimal("1.54"));
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

        return BigDecimal.valueOf(Math.PI).multiply(radiusSquared);
    }

    public BigDecimal circumference() {
        return new BigDecimal("2").multiply(new BigDecimal(Math.PI)).multiply(this.getRadius());
    }
}
