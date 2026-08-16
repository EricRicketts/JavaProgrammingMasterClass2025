package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    public static List<String> processEmployees(List<Employee> employees) {
        class EmployeeData {
            private Employee employee;
            private String fullName;
            private int yearsWorked;
            EmployeeData(Employee employee) {
                this.employee = employee;
                this.fullName = this.employee.firstName() + " " + this.employee.lastName();
                this.yearsWorked = LocalDateTime.now().getYear() - employee.hireDateTime().getYear();
            }

            public Employee getEmployee() {
                return this.employee;
            }

            public String getFullName() {
                return this.fullName;
            }

            public int getYearsWorked() {
                return this.yearsWorked;
            }
        }

        List<String> employeeData = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeData employeeInformation = new EmployeeData(employee);
            employeeData.add(
                "Employee Full Name: " +
                    employeeInformation.getFullName() + " Employee Years Worked: " +
                    employeeInformation.getYearsWorked()
            );
        }
        return employeeData;
    }
    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>(
            List.of(
                new Employee(
                    "Kenneth",
                    "Ludwig",
                    LocalDateTime.of(2001, 4, 14, 14, 14, 14)
                ),
                new Employee(
                    "Gabriel",
                    "Hunter",
                    LocalDateTime.of(2000, 2, 5, 18, 3, 2)
                ),
                new Employee(
                    "Abel",
                    "Baker",
                    LocalDateTime.of(2004, 10, 15, 10, 30, 45)
                ),
                new Employee(
                    "Issac",
                    "Job",
                    LocalDateTime.of(2020, 7, 17, 7, 14, 28)
                ),
                new Employee(
                    "Clarence",
                    "Darrow",
                    LocalDateTime.of(2022, 6, 12, 6, 54, 50)
                ),
                new Employee(
                    "Eric",
                    "Fulbright",
                    LocalDateTime.of(2017, 1, 9, 3, 28, 9)
                )
            )
        );
    }

    @Test
    public void testProcessEmployees() {
        List<String> result = processEmployees(employees);
        for (String employeeString : result) {
            String[] parts =
                employeeString.split("Employee Full Name: | Employee Years Worked: ");
            int f = 1;
        }
    }
}
