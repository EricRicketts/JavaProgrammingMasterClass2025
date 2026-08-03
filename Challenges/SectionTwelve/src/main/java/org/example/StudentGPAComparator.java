package org.example;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<SecondStudent> {

    @Override
    public int compare(SecondStudent s1, SecondStudent s2) {
        return (s1.getGpa() + s1.getName() + s1.getId())
            .compareTo(s2.getGpa() + s2.getName() + s2.getId());
    }
}
