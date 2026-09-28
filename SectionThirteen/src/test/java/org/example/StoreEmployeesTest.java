package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreEmployeesTest {

    private List<StoreEmployee> storeEmployees;

    @BeforeEach
    public void setUp() {
        storeEmployees = new ArrayList<>(
            List.of(
                new StoreEmployee(
                    223344,
                    1997,
                    "Daffy Duck",
                    "Barnes and Noble"
                ),
                new StoreEmployee(
                    987654,
                    2000,
                    "Speed Gonzales",
                    "Walmart"
                ),
                new StoreEmployee(
                    123456,
                    1996,
                    "Bugs Bunny",
                    "Target"
                ),
                new StoreEmployee(
                    112233,
                    1998,
                    "Elmer Fudd",
                    "Abercrombie"
                ),
                new StoreEmployee(
                    223344,
                    1990,
                    "Road Runner",
                    "Harris Teeter"
                ),
                new StoreEmployee(
                    223344,
                    2010,
                    "WyleE Coyote",
                    "Lowes"
                )
            )
        );
    }

    @Test
    public void testDefaultSortingShouldBeByStore() {
        var sortedStoreEmployees = new ArrayList<>(
            List.of(
                new StoreEmployee(
                    112233,
                    1998,
                    "Elmer Fudd",
                    "Abercrombie"
                ),
                new StoreEmployee(
                    223344,
                    1997,
                    "Daffy Duck",
                    "Barnes and Noble"
                ),
                new StoreEmployee(
                    223344,
                    1990,
                    "Road Runner",
                    "Harris Teeter"
                ),
                new StoreEmployee(
                    223344,
                    2010,
                    "WyleE Coyote",
                    "Lowes"
                ),
                new StoreEmployee(
                    123456,
                    1996,
                    "Bugs Bunny",
                    "Target"
                ),
                new StoreEmployee(
                    987654,
                    2000,
                    "Speed Gonzales",
                    "Walmart"
                )
            )
        );

        var genericEmployee = new StoreEmployee();
        var comparator = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator);

        assertEquals(sortedStoreEmployees, storeEmployees);
    }

    @Test
    public void testAnyAdditionalSortingIsDoneByYearStarted() {
        var sortedStoreEmployees = new ArrayList<>(
            List.of(
                new StoreEmployee(
                    112233,
                    1998,
                    "Elmer Fudd",
                    "Abercrombie"
                ),
                new StoreEmployee(
                    567890,
                    1989,
                    "Yosemite Sam",
                    "Barnes and Noble"
                ),
                new StoreEmployee(
                    223344,
                    1997,
                    "Daffy Duck",
                    "Barnes and Noble"
                ),
                new StoreEmployee(
                    223344,
                    1990,
                    "Road Runner",
                    "Harris Teeter"
                ),
                new StoreEmployee(
                    223344,
                    2010,
                    "WyleE Coyote",
                    "Lowes"
                ),
                new StoreEmployee(
                    123456,
                    1996,
                    "Bugs Bunny",
                    "Target"
                ),
                new StoreEmployee(
                    987654,
                    2000,
                    "Speed Gonzales",
                    "Walmart"
                )
            )
        );

        storeEmployees.add(
            new StoreEmployee(
                567890,
                1989,
                "Yosemite Sam",
                "Barnes and Noble"
            )
        );

        var genericStoreEmployee = new StoreEmployee();
        var comparator = genericStoreEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator);

        assertEquals(sortedStoreEmployees, storeEmployees);
    }
}
