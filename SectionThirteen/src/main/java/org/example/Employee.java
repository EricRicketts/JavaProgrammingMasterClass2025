package org.example;

public class Employee {

    private int employeeId, yearStarted;
    private String name;

    public Employee(int employeeId, int yearStarted, String name) {
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
        this.name = name;
    }

    public Employee() {
        this.employeeId = 0;
        this.yearStarted = 0;
        this.name = "Unknown";
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
