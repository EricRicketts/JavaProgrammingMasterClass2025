import org.example.CodingExerciseSixDecimalComparatorThreePlaces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseSixTest {

    double[] firstNumbers = new double[]{
            -3.1756, 3.175, 3.0, -3.123, 50.1357, 123.5312
    };
    double[] secondNumbers = new double[]{
            -3.175, 3.176, 3.0, 3.123, 50.1356, 123.5306
    };
    boolean[] expected = new boolean[]{
            true, false, true, false, true, false
    };

    @Test
    public void equalToThreeDecimalsTest() {
        CodingExerciseSixDecimalComparatorThreePlaces test =
                new CodingExerciseSixDecimalComparatorThreePlaces();
        for (int i = 0; i < expected.length; i++) {
            double first = firstNumbers[i];
            double second = secondNumbers[i];
            Assertions.assertEquals(
                    expected[i],
                    test.areEqualByThreeDecimalPlaces(first, second)
            );
        }
    }
}
