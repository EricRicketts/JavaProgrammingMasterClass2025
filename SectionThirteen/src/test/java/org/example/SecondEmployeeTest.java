package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondEmployeeTest {

    List<SecondEmployee> employees;
    SecondEmployeeComparator<SecondEmployee> comparator;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>(
            List.of(
                new SecondEmployee(10001, "Ralph", 2015),
                new SecondEmployee(10005, "Carol", 2021),
                new SecondEmployee(10022, "Jane", 2013),
                new SecondEmployee(13151, "Laura", 2020),
                new SecondEmployee(10050, "Jim", 2018)
            )
        );

        comparator = new SecondEmployeeComparator<>();
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
        for (SecondEmployee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        String result = sb.toString().stripTrailing();

        assertEquals(expected, result);
    }

    @Test
    public void testDefaultSortWhichIsByEmployeeNameWithNestedClass() {
        String expected = """
            10005 Carol    2021
            10022 Jane     2013
            10050 Jim      2018
            13151 Laura    2020
            10001 Ralph    2015""";
        StringBuilder sb = new StringBuilder();
        employees.sort(new SecondEmployee.SecondEmployeeComparator<>());
        for (SecondEmployee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        String result = sb.toString().stripTrailing();

        assertEquals(expected, result);
    }
}
