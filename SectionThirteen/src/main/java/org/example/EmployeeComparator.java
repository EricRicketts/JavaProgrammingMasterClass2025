package org.example;

import java.util.Comparator;

import static org.example.SecondEmployee.SecondEmployeeComparator.originalCompare;

public class EmployeeComparator <T extends Employee>
    implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        String firstEmployeeName = o1.getName();
        String secondEmployeeName = o2.getName();
        int compareNames = firstEmployeeName.compareTo(secondEmployeeName);
        if (compareNames != 0) {
            return compareNames;
        }

        int firstEmployeeId = o1.getEmployeeId();
        int secondEmployeeId = o2.getEmployeeId();
        int compareEmployeeIds = firstEmployeeId - secondEmployeeId;
        if (compareEmployeeIds != 0) {
            return compareEmployeeIds;
        }

        int firstEmployeeYearStarted = o1.getYearStarted();
        int secondEmployeeYearStarted = o2.getYearStarted();
        int compareEmployeeYearStarted = firstEmployeeYearStarted - secondEmployeeYearStarted;
        if (compareEmployeeYearStarted != 0) {
            return compareEmployeeYearStarted;
        }

        return 0;
    }
}
