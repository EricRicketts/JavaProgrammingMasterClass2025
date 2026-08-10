package org.example;

import java.util.Comparator;

public class SecondEmployee {

    public static class SecondEmployeeComparator <T extends SecondEmployee>
        implements Comparator<SecondEmployee> {

        private String sortType;

        public SecondEmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        public SecondEmployeeComparator() {
            this("name");
        }

        public String getSortType() {
            return sortType;
        }

        public void setSortType(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(SecondEmployee o1, SecondEmployee o2) {
            if (this.getSortType().equalsIgnoreCase("name")) {
                int compareEmployeeNames = o1.getName().compareTo(o2.getName());
                if (compareEmployeeNames != 0) {
                    return compareEmployeeNames;
                }
            }
            if (this.getSortType().equalsIgnoreCase("employeeId")) {
                int compareEmployeeIds = o1.getEmployeeId() - o2.getEmployeeId();
                if (compareEmployeeIds != 0) {
                    return compareEmployeeIds;
                }
            }
            if (this.getSortType().equalsIgnoreCase("yearStarted")) {
                int compareEmployeeYearStarted = o1.getYearStarted() - o2.getYearStarted();
                if (compareEmployeeYearStarted != 0) {
                    return compareEmployeeYearStarted;
                }
            }
            return 0;
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
