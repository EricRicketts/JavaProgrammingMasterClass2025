package org.example;

import java.util.Comparator;

import static org.example.SecondEmployeeComparator.originalSecondMethod;

public class SecondEmployee {

    public static class SecondEmployeeComparator <T extends SecondEmployee>
        implements Comparator<SecondEmployee> {

        @Override
        public int compare(SecondEmployee o1, SecondEmployee o2) {
            return originalCompare(o1, o2);
        }

        static int originalCompare(SecondEmployee o1, SecondEmployee o2) {
            return originalSecondMethod(
                o1.getName(), o2.getName(),
                o1.getEmployeeId(), o2.getEmployeeId(),
                o1.getYearStarted(), o2.getYearStarted(),
                o1, o2);
        }
    }
    private int employeeId;
    private String name;
    private int yearStarted;

    public SecondEmployee() {
    }

    public SecondEmployee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
