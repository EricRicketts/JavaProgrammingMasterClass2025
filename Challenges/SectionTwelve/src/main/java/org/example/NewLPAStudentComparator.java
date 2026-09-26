package org.example;

import java.math.BigDecimal;
import java.util.Comparator;

public class NewLPAStudentComparator implements Comparator<NewLPAStudent> {

    @Override
    public int compare(NewLPAStudent o1, NewLPAStudent o2) {
        return o1.getPercentComplete().compareTo(o2.getPercentComplete());
    }
}
