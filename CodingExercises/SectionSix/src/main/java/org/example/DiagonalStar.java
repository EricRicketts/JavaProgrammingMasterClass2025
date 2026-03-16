package org.example;

public class DiagonalStar {

    public static String printSquareStar(int number) {
        StringBuilder starPattern = new StringBuilder();
        StringBuilder currentRow = new StringBuilder();

        if (number < 5) return "Invalid Value";
        for (int row = 1; row <= number; row++) {
            if (row == 1) {
                starPattern.append("*".repeat(number)).append("\n");
                continue;
            }
            if (row == number) {
                starPattern.append("*".repeat(number)).append("\n");
                break;
            }
            for (int col = 1; col <= number; col++) {
                boolean appendStarCondition =
                    (col == 1) || (col == row) || ((col == (number - row) + 1));
                if (appendStarCondition) {
                    currentRow.append("*");
                } else if (col == number) {
                    currentRow.append("*" + "\n");
                } else {
                    currentRow.append(" ");
                }
            }
            starPattern.append(currentRow);
            currentRow.setLength(0);
        }
        return starPattern.toString();
    }
}
