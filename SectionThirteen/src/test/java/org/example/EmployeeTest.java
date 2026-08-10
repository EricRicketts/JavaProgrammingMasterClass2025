package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    List<Employee> employees;
    EmployeeComparator<Employee> comparator;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>(
            List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carol", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)
            )
        );

        comparator = new EmployeeComparator<>();
    }

    @Test
    public void testDefaultSortWhichIsByEmployeeName() {
        String expected = """
            10005 Carol    2021
            10022 Jane     2013
            10050 Jim      2018
            13151 Laura    2020
            10001 Ralph    2015""";
        StringBuilder sb = new StringBuilder();
        employees.sort(comparator);
        for (Employee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        String result = sb.toString().stripTrailing();

        assertEquals(expected, result);
    }
}
