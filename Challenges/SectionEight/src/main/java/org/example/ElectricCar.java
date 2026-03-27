package org.example;

public class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = this.checkAvgKmPerCharge(avgKmPerCharge);
        this.batterySize = this.checkBatterySize(batterySize);
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
        this.avgKmPerCharge = this.checkAvgKmPerCharge(avgKmPerCharge);
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = this.checkBatterySize(batterySize);
    }

    private double checkAvgKmPerCharge(double avgKmPerCharge) {
        return (avgKmPerCharge < 0) ? 300 : avgKmPerCharge;
    }

    private int checkBatterySize(int batterySize) {
        return (batterySize < 0) ? 50 : batterySize;
    }

}
