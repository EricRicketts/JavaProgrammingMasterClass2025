package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiagonalStarTest {

    String expected, result;

    @Test
    public void testDiagonalStar() {
        Assertions.assertEquals("Invalid Value", DiagonalStar.printSquareStar(4));
    }

    @Test
    public void testDiagonalStarFive() {
        expected = "*****\n" + "** **\n" + "* * *\n" + "** **\n" + "*****\n";
        result = DiagonalStar.printSquareStar(5);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDiagonalStarEight() {
        expected = "********\n" + "**    **\n" + "* *  * *\n" + "*  **  *\n" + "*  **  *\n" +
        "* *  * *\n" +  "**    **\n" + "********\n";
        result = DiagonalStar.printSquareStar(8);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDiagonalStarTwenty() {
        expected =
        "********************\n" +
        "**                **\n" +
        "* *              * *\n" +
        "*  *            *  *\n" +
        "*   *          *   *\n" +
        "*    *        *    *\n" +
        "*     *      *     *\n" +
        "*      *    *      *\n" +
        "*       *  *       *\n" +
        "*        **        *\n" +
        "*        **        *\n" +
        "*       *  *       *\n" +
        "*      *    *      *\n" +
        "*     *      *     *\n" +
        "*    *        *    *\n" +
        "*   *          *   *\n" +
        "*  *            *  *\n" +
        "* *              * *\n" +
        "**                **\n" +
        "********************\n";
        result = DiagonalStar.printSquareStar(20);
        Assertions.assertEquals(expected, result);
    }
}
