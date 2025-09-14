import org.example.MinutesToYearsDaysCalculator;
import org.example.PlayingCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayingCatTest {

    boolean expected, result;
    @Test
    public void testPlayingCat() {
        boolean[] isSummerValues = new  boolean[]{true, false, false, true, true};
        int[] temperatures = new  int[]{10, 36, 35, 45, 46};
        boolean[] expectedResults = new  boolean[]{false, false, true, true, false};

        for (int i = 0; i < isSummerValues.length; i++) {
            boolean isSummerValue = isSummerValues[i];
            int temperature = temperatures[i];
            expected = expectedResults[i];
            result = PlayingCat.isCatPlaying(isSummerValue, temperature);

            Assertions.assertEquals(expected, result);
        }
    }
}
