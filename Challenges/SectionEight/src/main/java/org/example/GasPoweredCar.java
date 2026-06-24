package org.example;

import java.math.BigDecimal;

public class GasPoweredCar extends Car {
    private BigDecimal avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, BigDecimal avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = AutoChecks.checkAvgKmPerLitre(avgKmPerLitre);
        this.cylinders = AutoChecks.checkCylinders(cylinders);
    }


    @Override
    public String startEngine() {
        return super.startEngine() + " which needs time to warm-up in cold weather.";
    }

    @Override
    public String drive() {
        return super.drive() + " on a pleasant Spring day.";
    }

    @Override
    protected String runEngine() {
        return super.runEngine() + " and is loud given the large amount of horsepower.";
    }

    public BigDecimal getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public void setAvgKmPerLitre(BigDecimal avgKmPerLitre) {
        this.avgKmPerLitre = AutoChecks.checkAvgKmPerLitre(avgKmPerLitre);
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = AutoChecks.checkCylinders(cylinders);
    }
}