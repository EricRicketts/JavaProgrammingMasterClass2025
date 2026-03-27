package org.example;

public class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = (avgKmPerCharge < 0) ? 300.00 : avgKmPerCharge;
        this.batterySize = (batterySize < 0) ? 50 : batterySize;
    }

    @Override
    public String startEngine() {
        return super.startEngine() + " " + "which is the future of all cars.";
    }

    @Override
    public String drive() {
        return super.drive() + " " + "which is quite a pleasant experience.";
    }

    @Override
    protected String runEngine() {
        return super.runEngine() + " " + "which has no engine but electric motors.";
    }

    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public void setAvgKmPerCharge(double avgKmPerCharge) {
        this.avgKmPerCharge = avgKmPerCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }
}
