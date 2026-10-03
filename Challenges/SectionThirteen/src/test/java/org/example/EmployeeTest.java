package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    public static List<String> processEmployees(List<Employee> employees) {
        return processEmployees(employees, "none");
    }

    public static List<String> processEmployees(List<Employee> employees, String sortKey) {
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

            public String getLastName() {
                return this.employee.lastName();
            }

            public String getFirstName() {
                return this.employee.firstName();
            }

            public int getYearsWorked() {
                return this.yearsWorked;
            }
        }

        List<EmployeeData> employeeDataList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDataList.add(new EmployeeData(employee));
        }

        var sortByYearsWorked = new Comparator<EmployeeData>() {
            @Override
            public int compare(EmployeeData o1, EmployeeData o2) {
                return Integer.compare(o1.getYearsWorked(), o2.getYearsWorked());
            }
        };

        var sortByLastNameThenFirstName = new Comparator<EmployeeData>() {
            @Override
            public int compare(EmployeeData o1, EmployeeData o2) {
                int result = o1.getLastName().compareTo(o2.getLastName());
                if (result != 0) {
                    return result;
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        if ("yearsWorked".equalsIgnoreCase(sortKey)) {
            employeeDataList.sort(sortByYearsWorked);
        } else if ("name".equalsIgnoreCase(sortKey)) {
            employeeDataList.sort(sortByLastNameThenFirstName);
        }

        List<String> result = new ArrayList<>();
        for (EmployeeData data : employeeDataList) {
            result.add(
                "Employee Full Name: " + data.getFullName() +
                    " Employee Years Worked: " + data.getYearsWorked()
            );
        }
        return result;
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

    @Test
    public void testProcessEmployeesGetFullNames() {
        String[] expectedFullNames = {
            "Kenneth Ludwig", "Gabriel Hunter", "Abel Baker",
            "Issac Job", "Clarence Darrow", "Eric Fulbright"
        };

        var employeeData = processEmployees(employees);
        for (int index = 0; index < employeeData.size(); index+=1) {
            String expectedName = expectedFullNames[index];
            String employee = employeeData.get(index);
            Pattern pattern = Pattern.compile("Employee Full Name: (\\w+)\\s+(\\w+)");
            Matcher matcher = pattern.matcher(employee);

            String first = null;
            String second = null;

            if (matcher.find()) {
                first = matcher.group(1);
                second = matcher.group(2);
            }
            String name = first + " " + second;
            assertEquals(expectedName, name);
        }
    }

    @Test
    public void testSortEmployeesByYearsWorked() {
        List<String> sortResult = processEmployees(employees, "yearsWorked");
        int[] expectedSortResults = {4, 6, 9, 22, 25, 26};

        for (int index = 0; index < expectedSortResults.length; index+=1) {
            int expectedSortResult = expectedSortResults[index];
            String resultantSortResult = sortResult.get(index).split("Years Worked: ")[1];
            assertEquals(expectedSortResult, Integer.valueOf(resultantSortResult));
        }
    }
}
