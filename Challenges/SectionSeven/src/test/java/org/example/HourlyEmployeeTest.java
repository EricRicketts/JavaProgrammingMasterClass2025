package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourlyEmployeeTest {

    HourlyEmployee employee = new HourlyEmployee(
            "Tweety Bird",
            "3/15/1920",
            "6/5/1990",
            (long) 223456,
            "8/2/1960",
            45.67
    );

    @Test
    public void testGetAndSetHourlyRate() {
        assertEquals(45.67, employee.getHourlyPayRate());
        employee.setHourlyPayRate(55.98);
        assertEquals(55.98, employee.getHourlyPayRate());
    }
}
