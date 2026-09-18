package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class NewLPAStudent extends NewStudent {

    private BigDecimal percentComplete;

    public NewLPAStudent(String name, String course, int id, int yearStarted) {
        super(name, course, id, yearStarted);
        Random random = new Random();
        this.percentComplete = new BigDecimal(
            random.nextDouble(0.00, 100.001)).setScale(2, RoundingMode.HALF_UP);
    }

    public NewLPAStudent() {
        super("Unknown", "None", 0, 0);
        this.percentComplete = new BigDecimal("0.00");
    }

    public BigDecimal getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(BigDecimal percentComplete) {
        this.percentComplete = percentComplete;
    }

    @Override
    public String toString() {
        return "%s %8.2f%%".formatted(super.toString(), this.getPercentComplete());
    }

    public static String printMoreLists(List<? extends NewStudent> students) {
        // Above generic means I can pass any collection of NewStudent or NewLPAStudent.
        StringBuilder sb = new StringBuilder();
        for (var student : students) {
            sb.append(student.getYearStarted()).append(": ").append(student).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (!super.matchFieldValue(fieldName, value)) {
            if (fieldName.equalsIgnoreCase("PERCENTCOMPLETE")) {
                BigDecimal currentPercentComplete =
                    this.getPercentComplete().setScale(2, RoundingMode.HALF_UP);
                BigDecimal currentValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
                return currentPercentComplete.compareTo(currentValue) <= 0;
            }
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        NewLPAStudent that = (NewLPAStudent) object;
        return java.util.Objects.equals(getPercentComplete(), that.getPercentComplete());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getPercentComplete());
    }
}
