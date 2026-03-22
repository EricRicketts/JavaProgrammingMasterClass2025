package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalariedEmployeeTest {

    SalariedEmployee employee;

    @BeforeEach
    public void setUp() {
        employee = new SalariedEmployee(
                "Bugs Bunny",
                "5/1/1929",
                "5/1/2009",
                (long) 110122,
                "5/1/1949",
                95_000.23,
                false
        );

    }

    @Test
    public void testSalariedEmployeeAnnualSalaryAndRetirementStatus() {
        Object[] expected = new Object[]{95_000.23, false};
        Object[] results = new Object[]{employee.getAnnualSalary(), employee.isRetired()};
        assertArrayEquals(expected, results);
    }

    @Test
    public void testSetAnnualSalary() {
        employee.setAnnualSalary(100_000.55);
        assertEquals(100_000.55, employee.getAnnualSalary());
    }

    @Test
    public void testSetEmployeeRetirement() {
        assertFalse(employee.isRetired());
        employee.retire();
        assertTrue(employee.isRetired());
        employee.setRetired(false);
        assertFalse(employee.isRetired());
    }
}
