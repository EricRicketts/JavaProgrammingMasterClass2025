package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreEmployeeTest {

    List<StoreEmployee> employees;
    StoreEmployee.StoreComparator<StoreEmployee> comparator;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>(
            List.of(
                new StoreEmployee(10001, "Ralph", 2015, "Macy's"),
                new StoreEmployee(10005, "Carol", 2021, "Target"),
                new StoreEmployee(10022, "Jane", 2013, "Walmart"),
                new StoreEmployee(13151, "Laura", 2020, "Macy's"),
                new StoreEmployee(10050, "Jim", 2018, "Walmart")
            )
        );
        comparator = new StoreEmployee().new StoreComparator<>();
    }

    @Test
    public void testSortByStoreThenName() {
        // Default sort is by store, then name (since default sortType is "name")
        employees.sort(comparator);
        
        // Expected order:
        // Macy's Laura
        // Macy's Ralph
        // Target Carol
        // Walmart Jane
        // Walmart Jim
        
        assertEquals("Macy's", employees.get(0).getStore());
        assertEquals("Laura", employees.get(0).getName());
        
        assertEquals("Macy's", employees.get(1).getStore());
        assertEquals("Ralph", employees.get(1).getName());
        
        assertEquals("Target", employees.get(2).getStore());
        assertEquals("Carol", employees.get(2).getName());
        
        assertEquals("Walmart", employees.get(3).getStore());
        assertEquals("Jane", employees.get(3).getName());
        
        assertEquals("Walmart", employees.get(4).getStore());
        assertEquals("Jim", employees.get(4).getName());
    }

    @Test
    public void testSortByStoreThenEmployeeId() {
        comparator.setSortType("employeeId");
        employees.sort(comparator);

        // Expected order for Macy's: Ralph (10001) then Laura (13151)
        assertEquals("Macy's", employees.get(0).getStore());
        assertEquals("Ralph", employees.get(0).getName());
        
        assertEquals("Macy's", employees.get(1).getStore());
        assertEquals("Laura", employees.get(1).getName());
    }

    @Test
    public void testSortByStoreThenYearStarted() {
        comparator.setSortType("yearStarted");
        employees.sort(comparator);

        // Macy's employees: Ralph (2015), Laura (2020)
        // Ralph should come before Laura
        assertEquals("Macy's", employees.get(0).getStore());
        assertEquals("Ralph", employees.get(0).getName());
        assertEquals(2015, employees.get(0).getYearStarted());

        assertEquals("Macy's", employees.get(1).getStore());
        assertEquals("Laura", employees.get(1).getName());
        assertEquals(2020, employees.get(1).getYearStarted());

        // Target: Carol (2021)
        assertEquals("Target", employees.get(2).getStore());

        // Walmart employees: Jane (2013), Jim (2018)
        // Jane should come before Jim
        assertEquals("Walmart", employees.get(3).getStore());
        assertEquals("Jane", employees.get(3).getName());
        assertEquals(2013, employees.get(3).getYearStarted());

        assertEquals("Walmart", employees.get(4).getStore());
        assertEquals("Jim", employees.get(4).getName());
        assertEquals(2018, employees.get(4).getYearStarted());
    }

    @Test
    public void testPigLatinNames() {
        List<String> normalNamesAndPigLatinNames = StoreEmployee.addPigLatinName(employees);
        String[] expectedNames = {
            "Ralph",
            "alphRay",
            "Carol",
            "arolCay",
            "Jane",
            "aneJay",
            "Laura",
            "auraLay",
            "Jim",
            "imJay"
        };

        for (int index = 0; index < normalNamesAndPigLatinNames.size(); index+=1) {
            if (index % 2 == 0) {
                String normalName = normalNamesAndPigLatinNames.get(index);
                assertEquals(expectedNames[index], normalName);
            } else {
                String pigLatinName = normalNamesAndPigLatinNames.get(index);
                assertEquals(expectedNames[index], pigLatinName);
            }
        }
    }
}
