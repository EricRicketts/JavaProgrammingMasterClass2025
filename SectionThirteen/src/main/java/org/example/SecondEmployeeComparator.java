package org.example;

import java.util.Comparator;

public class SecondEmployeeComparator<T extends SecondEmployee>
    implements Comparator<SecondEmployee> {

    @Override
    public int compare(SecondEmployee o1, SecondEmployee o2) {
        return originalSecondMethod(o1.getName(), o2.getName(),
            o1.getEmployeeId(), o2.getEmployeeId(),
            o1.getYearStarted(), o2.getYearStarted(),
            o1, o2
        );
    }

    static int originalSecondMethod(String name, String name2,
                                    int employeeId, int employeeId2,
                                    int yearStarted, int yearStarted2,
                                    SecondEmployee o1, SecondEmployee o2
    ) {
        int compareNames = name.compareTo(name2);
        if (compareNames != 0) {
            return compareNames;
        }

        int compareEmployeeIds = employeeId - employeeId2;
        if (compareEmployeeIds != 0) {
            return compareEmployeeIds;
        }

        int compareEmployeeYearStarted = yearStarted - yearStarted2;
        if (compareEmployeeYearStarted != 0) {
            return compareEmployeeYearStarted;
        }

        return 0;
    }
}
