package org.example;

public class Employee extends Worker {

    private final long employeeId;
    private final String hireDate;

    public Employee() {
        super();
        this.employeeId = -1;
        this.hireDate = "No Hire Date";
    }
    public Employee(String name, String birthDate, String endDate, long employeeId, String hireDate) {
        super(name, birthDate, endDate);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getHireDate() {
        return hireDate;
    }
}
