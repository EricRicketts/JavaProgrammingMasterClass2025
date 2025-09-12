import org.example.Scores;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveScoresTest {

    String expected, result;

    @Test
    public void calculateScoreFirstOverloadMethodTest() {
        expected = "Player Fred scored 100 points.";
        result = Scores.calculateScore("Fred", 100);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void calculateScoreSecondOverloadMethodTest() {
        expected = "Unnamed Player scored 200 points.";
        result = Scores.calculateScore(200);
        
        Assertions.assertEquals(expected, result);
    }
}
