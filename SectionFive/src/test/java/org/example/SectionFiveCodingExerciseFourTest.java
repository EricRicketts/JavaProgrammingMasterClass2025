import org.example.CodingExerciseFourBarkingDog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveCodingExerciseFourTest {

    boolean[] firstArguments = new boolean[]{true, false, true, true, true, true};
    int[] secondArguments = new int[]{1, 2, 8, -1, 23, 22};
    boolean[] expected = new boolean[]{true, false, false, false, true, false};

    @Test
    public void testSectionFiveCodingExerciseFour() {
        CodingExerciseFourBarkingDog coder = new CodingExerciseFourBarkingDog();
        for (int i = 0; i < firstArguments.length; i++) {
            boolean firstArgument = firstArguments[i];
            int secondArgument = secondArguments[i];
            Assertions.assertEquals(
                    expected[i],
                    coder.shouldWakeUp(firstArgument, secondArgument)
            );
        }
    }

}
