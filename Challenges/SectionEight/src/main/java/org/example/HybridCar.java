package org.example;

public class HybridCar extends Car {

    private double avgKmPerLitre;
    private int batterySize, cylinders;

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = AutoChecks.checkAvgKmPerLitreForHybrid(avgKmPerLitre);
        this.batterySize = AutoChecks.checkBatterySize(batterySize);
        this.cylinders = AutoChecks.checkCylinders(cylinders);
    }

    public double getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public void setAvgKmPerLitre(double avgKmPerLitre) {
        this.avgKmPerLitre = AutoChecks.checkAvgKmPerLitreForHybrid(avgKmPerLitre);
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = AutoChecks.checkBatterySize(batterySize);
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = AutoChecks.checkCylinders(cylinders);
    }
}
