package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public static List<String> addPigLatinName(List<? extends StoreEmployee> list) {
        class DecoratedEmployee extends StoreEmployee {
            private String pigLatinName;
            private StoreEmployee originalInstance;

            public DecoratedEmployee(String pigLatinName, StoreEmployee originalInstance) {
                this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            public String getPigLatinName() {
                return this.pigLatinName;
            }

            public StoreEmployee getOriginalInstance() {
                return this.originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        List<String> employeeNamesAndPigLatinNames = new ArrayList<>();
        for (int index = 0; index < newList.size(); index+=1) {
            DecoratedEmployee currentEmployee = newList.get(index);
            employeeNamesAndPigLatinNames.add(currentEmployee.getOriginalInstance().getName());
            employeeNamesAndPigLatinNames.add(currentEmployee.getPigLatinName());
        }

        return employeeNamesAndPigLatinNames;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }
}
