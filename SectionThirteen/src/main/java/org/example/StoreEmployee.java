package org.example;

import java.util.Comparator;

public class StoreEmployee extends Employee {

    private String store;

    public StoreEmployee(int employeeId, int yearStarted, String name, String store) {
        super(employeeId, yearStarted, name);
        this.store = store;
    }

    public StoreEmployee() {}

    @Override
    public String toString() {
        return "%-20s%s".formatted(store, super.toString());
    }

    public class StoreComparator <T extends StoreEmployee>
        implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int storeCompareResult = o1.store.compareTo(o2.store);
            if (storeCompareResult == 0) {
                return new Employee.EmployeeComparator<>()
                    .compareYearStarted(o1, o2);
            }
            return storeCompareResult;
        }
    }
}
