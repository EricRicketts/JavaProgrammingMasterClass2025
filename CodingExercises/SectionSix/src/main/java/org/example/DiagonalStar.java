package org.example;

public class DiagonalStar {

    public static String printSquareStar(int number) {
        StringBuilder starPattern = new StringBuilder();
        StringBuilder currentRow = new StringBuilder();

        if (number < 5) return "Invalid Value";
        for (int row = 1; row <= number; row++) {
            if (row == 1) {
                starPattern.append("*".repeat(number)).append("\n");
                continue; // this is needed because once we check for row == 1
                // we need to return to the loop and increment the row variable
            }
            if (row == number) {
                starPattern.append("*".repeat(number)).append("\n");
                break; // this is needed because we are at the end of the star pattern
                // and we need to break out of the loop
            }
            // the following code is for where we are not at the first or last rows
            // of the star pattern but in between the first and last rows
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
