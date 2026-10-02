package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StoreEmployeesTest {

    public static List<StoreEmployee> addPigLatinName(
        List<? extends StoreEmployee> list) {
        class DecoratedEmployee extends StoreEmployee implements PigLatinNamed {
            private final String pigLatinName;
            private final Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String getPigLatinName() {
                return pigLatinName;
            }

            @Override
            public String toString() {
                return originalInstance + " " + pigLatinName;
            }
        }

        List<StoreEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }
        return newList;
    }
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

    @Test
    public void testAddPigLatinName() {
        String errorString = "Expected element to implement PigLatinNamed";
        List<StoreEmployee> testList = new ArrayList<>(
            List.of(
                storeEmployees.getFirst(),
                storeEmployees.getLast()
            )
        );

        List<StoreEmployee> pigLatinList = addPigLatinName(testList);

        StoreEmployee first = pigLatinList.getFirst();
        if (first instanceof PigLatinNamed decorated) {
            assertEquals("affy DuckDay", decorated.getPigLatinName());
        } else {
            fail(errorString);
        }

        StoreEmployee last = pigLatinList.getLast();
        if (last instanceof PigLatinNamed decorated) {
            assertEquals("yleE CoyoteWay", decorated.getPigLatinName());
        } else {
            fail(errorString);
        }
    }
}
