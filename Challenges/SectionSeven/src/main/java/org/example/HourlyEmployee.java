package org.example;

public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee() {
        super();
        this.hourlyPayRate = 0.00;
    }
    public HourlyEmployee(String name,
                          String birthDate,
                          String endDate,
                          long employeeId,
                          String hireDate,
                          double hourlyPayRate) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        int hours = 40;
        return hours * this.getHourlyPayRate();
    }
}
