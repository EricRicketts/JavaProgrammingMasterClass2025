import org.example.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveIfThenElseStatementsTest {

    int myInt;
    String myString;


    @Test
    public void ifThenElseStatementsIfBranchTest(){
        myInt = 1;
        if (myInt < 2) {
            myString = "Number is less than two";
        } else {
            myString = "Number is greater than or equal to two";
        }
        Assertions.assertEquals("Number is less than two", myString);
    }

    @Test
    public void ifThenElseStatementsElseBranchTest() {
        myInt = 2;
        if (myInt < 2) {
            myString = "Number is less than two";
        } else {
            myString = "Number is greater than or equal to two";
        }
        Assertions.assertEquals("Number is greater than or equal to two", myString);
    }

    @Test
    public void ifThenElseStatementsElseIfBranchTest() {
        myInt = 3;
        if (myInt <= 2) {
            myString = "Number is less than or equal to two";
        } else if (myInt <= 3) {
            myString = "Number is less than or equal to three";
        } else {
            myString = "Number is greater than three";
        }

        Assertions.assertEquals("Number is less than or equal to three", myString);
    }

    @Test
    public void ifThenElseStatementsChallengeTest() {
        int score = 10_000;
        int levelCompleted = 8;
        int bonus = 200;
        boolean gameOver = true;
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
        }

        Assertions.assertEquals(11_600, finalScore);
    }

    @Test
    public void ifThenElseStatementsUseAMethodTest() {
        int finalScore = new App().calculateScore(10_000, true);
        int secondFinalScore = new App().calculateScore(10_000, false);
        Assertions.assertEquals(11_600, finalScore);
        Assertions.assertEquals(10_000, secondFinalScore);
    }

    @Test
    public void  methodTest() {
        int[] expected = {2300, 800};
        int[] results = {
                new App().calculateScore(true, 800, 5, 100),
                new  App().calculateScore(false, 800, 5, 100),
        };
        Assertions.assertArrayEquals(expected,results);
    }

    @Test
    public void methodTestWithVariableArguments() {
        int expected = 12_600;
        boolean gameOver = true;
        int score = 10_000;
        int levelCompleted = 8;
        int bonus = 200;

        int result = new App().calculateScore(gameOver, score, levelCompleted, bonus);
        Assertions.assertEquals(expected, result);
    }
}
