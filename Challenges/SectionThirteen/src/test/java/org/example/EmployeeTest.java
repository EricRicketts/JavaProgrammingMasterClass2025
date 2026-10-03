package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    public static List<String> processEmployees(List<Employee> employees) {
        class EmployeeData {
            private Employee employee;
            private String fullName;
            private int yearsWorked;
            EmployeeData(Employee employee) {
                LocalDateTime now = LocalDateTime.now();
                this.employee = employee;
                this.fullName = this.employee.firstName() + " " + this.employee.lastName();
                this.yearsWorked = now.getYear() - employee.hireDateTime().getYear();
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
    public void testProcessEmployeesForYearsWorked() {
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int[] yearsStarted = {2001, 2000, 2004, 2020, 2022, 2017};

        List<Integer> expectedYearsWorked = new ArrayList<>();

        for (int index = 0; index < yearsStarted.length; index+=1) {
            int yearStarted = yearsStarted[index];
            int yearsWorked = currentYear - yearStarted;
            expectedYearsWorked.add(yearsWorked);
        };

        var employeeData = processEmployees(employees);
        for (int index = 0; index < employeeData.size(); index+=1) {
            Integer actualYearsWorked = Integer.valueOf(
                employeeData.get(index).split("Years Worked: ")[1]);
            int yearsWorked = expectedYearsWorked.get(index);
            assertEquals(yearsWorked, actualYearsWorked);
        }
    }
}
