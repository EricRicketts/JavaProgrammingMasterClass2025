package org.example;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee>
    implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int compareEmployeeNames = o1.getName().compareTo(o2.getName());
        if (compareEmployeeNames != 0) {
            return compareEmployeeNames;
        }
        int compareEmployeeIds = o1.getEmployeeId() - o2.getEmployeeId();
        if (compareEmployeeIds != 0) {
            return compareEmployeeIds;
        }

        int compareEmployeeYearStarted = o1.getYearStarted() - o2.getYearStarted();
        if (compareEmployeeYearStarted != 0) {
            return compareEmployeeYearStarted;
        }
        return 0;
    }
}
