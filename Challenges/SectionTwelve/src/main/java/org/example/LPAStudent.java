package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

public class LPAStudent extends ThirdStudent implements QueryItem {

    private BigDecimal percentComplete;

    public LPAStudent() {
        Random random = new Random();
        this.percentComplete = new BigDecimal(
            random.nextDouble(0.00, 100.001)).setScale(2, RoundingMode.HALF_UP);
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

    public static String printMoreLists(List<? extends ThirdStudent> students) {
        // Above generic means I can pass any collection of ThirdStudent or LPAStudent.
        StringBuilder sb = new StringBuilder();
        for (var student : students) {
            sb.append(student.getYearStarted()).append(": ").append(student).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String localFieldName = fieldName.toUpperCase();
        return switch (localFieldName) {
            case "NAME" -> this.getName().split("\\s+")[0].equalsIgnoreCase(value);
            case "COURSE" -> this.getCourse().equalsIgnoreCase(value);
            case "YEARSTARTED" -> this.getYearStarted() == Integer.parseInt(value);
            default -> false;
        };
    }
}
