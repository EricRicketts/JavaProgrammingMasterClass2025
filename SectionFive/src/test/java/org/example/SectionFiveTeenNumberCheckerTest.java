import org.example.TeenNumberChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SectionFiveTeenNumberCheckerTest {

    @Test
    public void testIsTeen() {
        int[] ages = new int[]{12, 13, 19, 20};
        boolean[] results = new  boolean[]{false, true, true, false};
        for (int i = 0; i < ages.length; i++) {
            Assertions.assertEquals(results[i], TeenNumberChecker.isTeen(ages[i]));
        }
    }

    @Test
    public void testHasTeen() {
        int[] firstAges = new int[]{9, 23, 22, -14, 13};
        int[] secondAges = new int[]{99, 15, 23, 20, 10};
        int[] thirdAges = new int[]{19, 42, 34, 12, 15};
        boolean[] results = new  boolean[]{true, true, false, false, true};

        for (int i = 0; i < firstAges.length; i++) {
            int firstAge = firstAges[i];
            int secondAge = secondAges[i];
            int thirdAge = thirdAges[i];
            boolean result = results[i];
            Assertions.assertEquals(result, TeenNumberChecker.hasTeen(firstAge, secondAge, thirdAge));
        }
    }
}
