package org.example;

public class GasPoweredCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
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

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public void setAvgKmPerLitre(double avgKmPerLitre) {
        this.avgKmPerLitre = AutoChecks.checkAvgKmPerLitre(avgKmPerLitre);
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = AutoChecks.checkCylinders(cylinders);
    }
}