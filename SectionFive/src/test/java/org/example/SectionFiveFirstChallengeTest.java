import org.example.FirstChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SectionFiveFirstChallengeTest {
    // scores to test: 1500, 1000, 500, 100 and 25
    static FirstChallenge firstChallenge;
    String[] names = {"Tim", "Bill", "Fred", "Elmer", "Sam", "Abel", "Aaron", "Butch", "Apex"};
    String[] expected = {
            "Tim managed to get into position 1 on the high score list.",
            "Bill managed to get into position 1 on the high score list.",
            "Fred managed to get into position 2 on the high score list.",
            "Elmer managed to get into position 3 on the high score list.",
            "Sam managed to get into position 4 on the high score list.",
            "Abel managed to get into position 2 on the high score list.",
            "Aaron managed to get into position 3 on the high score list.",
            "Butch managed to get into position 4 on the high score list.",
            "Apex managed to get into position 4 on the high score list."
    };
    int[] scores = {1500, 1000, 500, 100, 25, 999, 499, 99, -10};

    @BeforeAll
    public static void setup() {
        firstChallenge = new FirstChallenge();
    }

    @Test
    public void testScoresAndPositions() {
        for (int i = 0; i < scores.length; i++) {
            int position = firstChallenge.calculateHighScorePosition(scores[i]);
            Assertions.assertEquals(
                    expected[i],
                    firstChallenge.displayHighScorePosition(names[i], position)
            );
        }
    }
}
