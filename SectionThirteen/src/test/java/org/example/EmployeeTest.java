package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Employee employeeOne, employeeTwo;
    private int employeeId, yearStarted;
    private String name;

    @BeforeEach
    public void setUp() {
        employeeId = 112233;
        yearStarted = 1999;
        name = "Elmer Fudd";
        employeeOne = new Employee(employeeId, yearStarted, name);
        employeeTwo = new Employee();
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
}
