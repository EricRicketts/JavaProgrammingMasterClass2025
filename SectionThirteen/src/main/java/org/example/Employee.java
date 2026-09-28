package org.example;

import java.util.Comparator;

public class Employee {

    public static class EmployeeComparator
        <T extends Employee> implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            Integer firstId = o1.getEmployeeId();
            Integer secondId = o2.getEmployeeId();

            String[] FirstFullName = o1.getName().split("\\s+");
            String[] SecondFullName = o2.getName().split("\\s+");

            String firstFirstName = FirstFullName[0];
            String firstLastName = FirstFullName[1];
            String secondFirstName = SecondFullName[0];
            String secondLastName = SecondFullName[1];

            Integer firstYearStarted = o1.getYearStarted();
            Integer secondYearStarted = o2.getYearStarted();

            if (firstId.compareTo(secondId) != 0) {
                return firstId.compareTo(secondId);
            } else if (firstLastName.compareTo(secondLastName) != 0) {
                return firstLastName.compareTo(secondLastName);
            } else if (firstFirstName.compareTo(secondFirstName) != 0) {
                return firstFirstName.compareTo(secondFirstName);
            } else {
                return firstYearStarted.compareTo(secondYearStarted);
            }
        }
    }
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (this.getClass() != obj.getClass())) return false;
        Employee other = (Employee) obj;

        return this.getEmployeeId() == other.getEmployeeId() &&
            this.getYearStarted() == other.getYearStarted() &&
            this.getName().equalsIgnoreCase(other.getName());
    }
}
