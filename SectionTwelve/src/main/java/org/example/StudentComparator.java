package org.example;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return
            (o1.getLastName() + o1.getFirstName()
                + o1.getId() + o1.getGpa()
            )
            .compareTo(o2.getLastName() + o2.getFirstName()
                + o2.getId() + o2.getGpa()
            );
    }
}
