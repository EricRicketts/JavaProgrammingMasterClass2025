import org.example.CodingExerciseOnePositiveNegativeZero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseOneTest {

    @Test
    public void testPositiveNegativeOrZero() {
        int[] values = {1, -1, 0};
        String[] expected = {"positive", "negative", "zero"};
        CodingExerciseOnePositiveNegativeZero challengeOnePositiveNegativeZero =
                new CodingExerciseOnePositiveNegativeZero();
        for (int index = 0; index < values.length; index++) {
            int value =  values[index];
            String expectedValue = expected[index];
            String result = challengeOnePositiveNegativeZero.checkNumber(value);
            Assertions.assertEquals(expectedValue, result);
        }
    }
}
