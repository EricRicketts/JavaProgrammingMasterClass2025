package org.example;

public class DiagonalStar {

    public static String printSquareStar(int number) {
        String squareStar = "";
        String star = "*";
        String space = " ";
        if (number < 5) return "Invalid Value";
        for (int row = 1; row <= number; row++) {
            if (row == 1 || row == number) {
                squareStar = squareStar.concat(star.repeat(number) + "\n");
                continue;
            }
            for  (int col = 1; col <= number; col++) {
                if (col == 1) {
                    squareStar = squareStar.concat(star);
                } else if (col == number) {
                    squareStar = squareStar.concat(star) + "\n";
                } else if (row == col) {
                    squareStar = squareStar.concat(star);
                }  else if (col == number - row + 1) {
                    squareStar = squareStar.concat(star);
                } else {
                    squareStar = squareStar.concat(space);
                }
            }
        }
        /*
            *****
            ** **
            * * *
            ** **
            *****
        */
        return squareStar;
    }
}
