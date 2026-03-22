package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    Employee firstEmployee, secondEmployee;
    Object[] expected, results;

    @BeforeEach
    public void setUp() {
        firstEmployee = new Employee(
                "Daffy Duck",
                "2/1/1935",
                "2/1/2005",
                11034,
                "2/1/1955");
        secondEmployee = new Employee();
    }

    @Test
    public void testFirstEmployee() {
        expected = new Object[]{"Daffy Duck", "2/1/1935", "2/1/2005", (long) 11034, "2/1/1955", 0.0};
        results = new Object[]{
            firstEmployee.getName(), firstEmployee.getBirthDate(), firstEmployee.getEndDate(),
            firstEmployee.getEmployeeId(), firstEmployee.getHireDate(), firstEmployee.collectPay()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testSecondEmployee() {
        expected = new Object[]{"Anonymous", "No Birth Date", "No End Date", (long) -1, "No Hire Date", 0.0};
        results = new Object[]{
                secondEmployee.getName(), secondEmployee.getBirthDate(), secondEmployee.getEndDate(),
                secondEmployee.getEmployeeId(), secondEmployee.getHireDate(), secondEmployee.collectPay()
        };
        assertArrayEquals(expected, results);
    }

    @Test
    public void testEmployeeTerminate() {
        firstEmployee.terminate("4/4/2005");
        assertEquals("4/4/2005", firstEmployee.getEndDate());
    }
}
