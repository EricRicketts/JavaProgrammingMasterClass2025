package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Employee employeeOne, employeeTwo;
    private int employeeId, yearStarted;
    private String name;

    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employeeId = 112233;
        yearStarted = 1999;
        name = "Elmer Fudd";
        employeeOne = new Employee(employeeId, yearStarted, name);
        employeeTwo = new Employee();

        employees = new ArrayList<>(List.of(
            new Employee(445566, 2002, "Margot Kitty"),
            new Employee(234567, 1998, "John Burns"),
            new Employee(556677, 2003, "Michael Zed"),
            new Employee(234567, 1999, "Patrick Burns"),
            new Employee(334455, 2001, "Debbie Alsop"),
            new Employee(234567, 2000, "Patrick Burns")
            )
        );
    }

    @Nested
    @DisplayName("test employee getters")
    class TestEmployeeGetters {

        @Test
        public void testGetEmployeeId() {
            assertEquals(employeeId, employeeOne.getEmployeeId());
        }

        @Test
        public void testGetEmployeeYearStarted() {
            assertEquals(yearStarted, employeeOne.getYearStarted());
        }

        @Test
        public void testGetEmployeeName() {
            assertEquals(name, employeeOne.getName());
        }
    }

    @Nested
    @DisplayName("test employee setters")
    class TestEmployeeSetters {

        @Test
        public void testSetEmployeeId() {
            assertEquals(employeeId, employeeOne.getEmployeeId());

            int newEmployeeId = 223344;
            employeeOne.setEmployeeId(newEmployeeId);

            assertEquals(newEmployeeId, employeeOne.getEmployeeId());
        }

        @Test
        public void testSetEmployeeYearStarted() {
            assertEquals(yearStarted, employeeOne.getYearStarted());

            int newYearStarted = 2001;
            employeeOne.setYearStarted(newYearStarted);

            assertEquals(newYearStarted, employeeOne.getYearStarted());
        }

        @Test
        public void testSetEmployeeName() {
            assertEquals(name, employeeOne.getName());

            String newEmployeeName = "Bugs Bunny";
            employeeOne.setName(newEmployeeName);

            assertEquals(newEmployeeName, employeeOne.getName());
        }
    }

    @Nested
    @DisplayName("test no argument constructor")
    class TestNoArgumentConstructor {

        @Test
        public void testNoArgumentConstructorGetEmployeeId() {
            assertEquals(0, employeeTwo.getEmployeeId());
        }

        @Test
        public void testNoArgumentConstructorGetEmployeeYearStarted() {
            assertEquals(0, employeeTwo.getYearStarted());
        }

        @Test
        public void testNoArgumentConstructorGetEmployeeName() {
            assertEquals("Unknown", employeeTwo.getName());
        }
    }

    @Nested
    @DisplayName("test employee toString")
    class TestEmployeeToString {

        @Test
        public void testEmployeeToString() {
            String expected = "112233 Elmer Fudd 1999";
            String result = employeeOne.toString();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test sorting employees")
    class TestSortEmployees {

        @Test
        public void testSortEmployeesSortOderIdLastNameFirstNameYearStarted() {
            var sortedEmployees = new ArrayList<>(List.of(
                new Employee(234567, 1998, "John Burns"),
                new Employee(234567, 1999, "Patrick Burns"),
                new Employee(234567, 2000, "Patrick Burns"),
                new Employee(334455, 2001, "Debbie Alsop"),
                new Employee(445566, 2002, "Margot Kitty"),
                new Employee(556677, 2003, "Michael Zed")
                )
            );

            employees.sort(new Employee.EmployeeComparator<>());

            assertEquals(sortedEmployees, employees);
        }

    }
}
