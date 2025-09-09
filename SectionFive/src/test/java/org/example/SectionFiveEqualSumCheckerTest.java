import org.example.EqualSumChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveEqualSumCheckerTest {

    @Test
    public void test() {
        int[] firstArguments = new  int[]{1, 2, -3, -5, 5, 6};
        int[] secondArguments = new  int[]{1, -2, -3, 4, 5, 7};
        int[] expectedSum = new int[]{2, 0, -6, -1, 20, 14};
        boolean[] results = new boolean[]{true, true, true, true, false, false};
        for (int i = 0; i < expectedSum.length; i++) {
            int first = firstArguments[i];
            int second = secondArguments[i];
            int sum = expectedSum[i];
            Assertions.assertEquals(results[i], EqualSumChecker.hasEqualSum(first, second, sum));
        }
    }
}
