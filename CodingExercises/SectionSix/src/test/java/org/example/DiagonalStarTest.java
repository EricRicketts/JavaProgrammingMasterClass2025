package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalStarTest {

    String expected, result;

    @Test
    public void testDiagonalStarNumberFive() {
        expected = "*****\n** **\n* * *\n** **\n*****\n";
        result = DiagonalStar.printSquareStar(5);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalStarNumberSix() {
        expected = "******\n**  **\n* ** *\n* ** *\n**  **\n******\n";
        result = DiagonalStar.printSquareStar(6);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalStarNumberSeven() {
        expected =
                "*******\n**   **\n* * * *\n*  *  *\n* * * *\n**   **\n*******\n";
        result = DiagonalStar.printSquareStar(7);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalStarNumberEight() {
        expected =
                "********\n**    **\n* *  * *\n*  **  *\n*  **  *\n* *  * *\n**    **\n********\n";
        result = DiagonalStar.printSquareStar(8);
        assertEquals(expected, result);
    }
}
