package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondEmployeeTest {

    List<SecondEmployee> employees;

    SecondEmployee.SecondEmployeeComparator<SecondEmployee> comparator;

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
        comparator = new SecondEmployee.SecondEmployeeComparator<>();
    }

    @Nested
    @DisplayName("test sorting by name")
    class TestSortByName {

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
        public void testDefaultSortWhichIsByEmployeeNameReversed() {
            String expected = """
            10001 Ralph    2015
            13151 Laura    2020
            10050 Jim      2018
            10022 Jane     2013
            10005 Carol    2021""";
            StringBuilder sb = new StringBuilder();
            employees.sort(comparator.reversed());
            for (SecondEmployee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            String result = sb.toString().stripTrailing();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test sorting by year started")
    class TestSortByYearStarted {

        @Test
        public void testSortByEmployeeYearStarted() {
            comparator.setSortType("yearStarted");
            String expected = """
            10022 Jane     2013
            10001 Ralph    2015
            10050 Jim      2018
            13151 Laura    2020
            10005 Carol    2021""";
            StringBuilder sb = new StringBuilder();
            employees.sort(comparator);
            for (SecondEmployee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            String result = sb.toString().stripTrailing();

            assertEquals(expected, result);
        }

        @Test
        public void testSortByEmployeeYearStartedReversed() {
            comparator.setSortType("yearStarted");
            String expected = """
            10005 Carol    2021
            13151 Laura    2020
            10050 Jim      2018
            10001 Ralph    2015
            10022 Jane     2013""";
            StringBuilder sb = new StringBuilder();
            employees.sort(comparator.reversed());
            for (SecondEmployee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            String result = sb.toString().stripTrailing();

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("test sort by employee id")
    class TestSortByEmployeeId {

        @Test
        public void testDefaultSortWhichIsByEmployeeId() {
            comparator.setSortType("employeeId");
            String expected = """
            10001 Ralph    2015
            10005 Carol    2021
            10022 Jane     2013
            10050 Jim      2018
            13151 Laura    2020""";
            StringBuilder sb = new StringBuilder();
            employees.sort(comparator);
            for (SecondEmployee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            String result = sb.toString().stripTrailing();

            assertEquals(expected, result);
        }

        @Test
        public void testDefaultSortWhichIsByEmployeeIdReversed() {
            comparator.setSortType("employeeId");
            String expected = """
            13151 Laura    2020
            10050 Jim      2018
            10022 Jane     2013
            10005 Carol    2021
            10001 Ralph    2015""";
            StringBuilder sb = new StringBuilder();
            employees.sort(comparator.reversed());
            for (SecondEmployee employee : employees) {
                sb.append(employee.toString()).append("\n");
            }
            String result = sb.toString().stripTrailing();

            assertEquals(expected, result);
        }
    }
}
