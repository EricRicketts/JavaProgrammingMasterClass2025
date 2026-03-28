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

    @Override
    public String startEngine() {
        return super.startEngine() + " the gas powered part makes noise but the battery is silent.";
    }

    @Override
    public String drive() {
        return super.drive() +
                " I can get long range with this car because of the extra power provided by the battery.";
    }

    @Override
    protected String runEngine() {
        return super.runEngine() + " when on battery only mode the card makes no noise.";
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
